
更多代码请见：https://github.com/xubo245/SparkLearning

spark源码解读系列环境：spark-2.0.1 （20161103github下载版）

# 1.理解 #

输出读取中常用到topK算法，RDD也提供了top方法。特别是RDD过大时，要慎用RDD的collect方法，建议使用take和top方法。如果要有序，可以使用top方法。

## 1.1 定义 ##

	  def top(num: Int)(implicit ord: Ordering[T]): Array[T] = withScope {
	    takeOrdered(num)(ord.reverse)
	  }

num为要取的额个数，ord为隐式转换，可以取最高的topK，也可以放入逆序取最低的topK，top方法调用的是takeOrdered方法。

## 1.2 源码理解 ##

###1.2.1 takeOrdered###
top调用的是takeOrdered，top调用的是takeOrdered的源码为：

	  /**
	   * Returns the first k (smallest) elements from this RDD as defined by the specified
	   * implicit Ordering[T] and maintains the ordering. This does the opposite of [[top]].
	   * For example:
	   * {{{
	   *   sc.parallelize(Seq(10, 4, 2, 12, 3)).takeOrdered(1)
	   *   // returns Array(2)
	   *
	   *   sc.parallelize(Seq(2, 3, 4, 5, 6)).takeOrdered(2)
	   *   // returns Array(2, 3)
	   * }}}
	   *
	   * @note this method should only be used if the resulting array is expected to be small, as
	   * all the data is loaded into the driver's memory.
	   *
	   * @param num k, the number of elements to return
	   * @param ord the implicit ordering for T
	   * @return an array of top elements
	   */

	  def takeOrdered(num: Int)(implicit ord: Ordering[T]): Array[T] = withScope {
	    if (num == 0) {
	      Array.empty
	    } else {
	      val mapRDDs = mapPartitions { items =>
	        // Priority keeps the largest elements, so let's reverse the ordering.
	        val queue = new BoundedPriorityQueue[T](num)(ord.reverse)
	        queue ++= util.collection.Utils.takeOrdered(items, num)(ord)
	        Iterator.single(queue)
	      }
	      if (mapRDDs.partitions.length == 0) {
	        Array.empty
	      } else {
	        mapRDDs.reduce { (queue1, queue2) =>
	          queue1 ++= queue2
	          queue1
	        }.toArray.sorted(ord)
	      }
	    }
	  }

理解：  
1.2.1.1 takeOrdered会使用有界的优先队列BoundedPriorityQueue，存储返回的k个元素。  
1.2.1.2 mapPartitions是对每一个partition进行操作，对每个partition元素集合items,调用org.apache.spark.util.collection.takeOrdered取num个数，然后生成由若干个partition组成的mapRDDs，每个partition为大小为k的有界优先队列queue  
1.2.1.3 然后进行reduce操作，reduce是将两个queue进行++操作，即将两个长度为k的queue1和queue2合并成一个长为1的queue。然后进行toArray和sort（ord）。++方法为BoundedPriorityQueue类中的方法，++会调用+=方法进行操作：

	  override def ++=(xs: TraversableOnce[A]): this.type = {
	    xs.foreach { this += _ }
	    this
	  }
	
	  override def +=(elem: A): this.type = {
	    if (size < maxSize) {
	      underlying.offer(elem)
	    } else {
	      maybeReplaceLowest(elem)
	    }
	    this
	  }
  具体可以查看BoundedPriorityQueue的方法

 sorted(ord)方法调用java.util.Arrays.sort，后面1.2.3.1 会讲到

###1.2.2 org.apache.spark.util.collection.takeOrdered###
org.apache.spark.util.collection.takeOrdered的takeOrdered是调用的com.google.common.collect.{Ordering => GuavaOrdering}
的方法，并且重写了compare方法，主要是Ordering默认的是从小到大，而top默认是取最大的num个元素

	val ordering = new GuavaOrdering[T] {
	      override def compare(l: T, r: T): Int = ord.compare(l, r)
	    }

然后再调用 ordering的leastOf方法，中间有java和scala的iterator容器的相互转换：

 	ordering.leastOf(input.asJava, num).iterator.asScala	
###1.2.3 com.google.common.collect.Ordering的leastOf方法###
  包的引入方式：在maven的pom文件中加入

  	 <dependency>
        <groupId>com.google.guava</groupId>
        <artifactId>guava</artifactId>
        <version>14.0.1</version>
        <scope>provided</scope>
      </dependency>

源码：

	 /**
	   * Returns the {@code k} least elements from the given iterator according to
	   * this ordering, in order from least to greatest.  If there are fewer than
	   * {@code k} elements present, all will be included.
	   *
	   * <p>The implementation does not necessarily use a <i>stable</i> sorting
	   * algorithm; when multiple elements are equivalent, it is undefined which
	   * will come first.
	   *
	   * @return an immutable {@code RandomAccess} list of the {@code k} least
	   *     elements in ascending order
	   * @throws IllegalArgumentException if {@code k} is negative
	   * @since 14.0
	   */
	  public <E extends T> List<E> leastOf(Iterator<E> elements, int k) {
	    checkNotNull(elements);
	    checkArgument(k >= 0, "k (%s) must be nonnegative", k);
	
	    if (k == 0 || !elements.hasNext()) {
	      return ImmutableList.of();
	    } else if (k >= Integer.MAX_VALUE / 2) {
	      // k is really large; just do a straightforward sorted-copy-and-sublist
	      ArrayList<E> list = Lists.newArrayList(elements);
	      Collections.sort(list, this);
	      if (list.size() > k) {
	        list.subList(k, list.size()).clear();
	      }
	      list.trimToSize();
	      return Collections.unmodifiableList(list);
	    }
	
	    /*
	     * Our goal is an O(n) algorithm using only one pass and O(k) additional
	     * memory.
	     *
	     * We use the following algorithm: maintain a buffer of size 2*k. Every time
	     * the buffer gets full, find the median and partition around it, keeping
	     * only the lowest k elements.  This requires n/k find-median-and-partition
	     * steps, each of which take O(k) time with a traditional quickselect.
	     *
	     * After sorting the output, the whole algorithm is O(n + k log k). It
	     * degrades gracefully for worst-case input (descending order), performs
	     * competitively or wins outright for randomly ordered input, and doesn't
	     * require the whole collection to fit into memory.
	     */
	    int bufferCap = k * 2;
	    @SuppressWarnings("unchecked") // we'll only put E's in
	    E[] buffer = (E[]) new Object[bufferCap];
	    E threshold = elements.next();
	    buffer[0] = threshold;
	    int bufferSize = 1;
	    // threshold is the kth smallest element seen so far.  Once bufferSize >= k,
	    // anything larger than threshold can be ignored immediately.
	
	    while (bufferSize < k && elements.hasNext()) {
	      E e = elements.next();
	      buffer[bufferSize++] = e;
	      threshold = max(threshold, e);
	    }
	
	    while (elements.hasNext()) {
	      E e = elements.next();
	      if (compare(e, threshold) >= 0) {
	        continue;
	      }
	
	      buffer[bufferSize++] = e;
	      if (bufferSize == bufferCap) {
	        // We apply the quickselect algorithm to partition about the median,
	        // and then ignore the last k elements.
	        int left = 0;
	        int right = bufferCap - 1;
	
	        int minThresholdPosition = 0;
	        // The leftmost position at which the greatest of the k lower elements
	        // -- the new value of threshold -- might be found.
	
	        while (left < right) {
	          int pivotIndex = (left + right + 1) >>> 1;
	          int pivotNewIndex = partition(buffer, left, right, pivotIndex);
	          if (pivotNewIndex > k) {
	            right = pivotNewIndex - 1;
	          } else if (pivotNewIndex < k) {
	            left = Math.max(pivotNewIndex, left + 1);
	            minThresholdPosition = pivotNewIndex;
	          } else {
	            break;
	          }
	        }
	        bufferSize = k;
	
	        threshold = buffer[minThresholdPosition];
	        for (int i = minThresholdPosition + 1; i < bufferSize; i++) {
	          threshold = max(threshold, buffer[i]);
	        }
	      }
	    }
	
	    Arrays.sort(buffer, 0, bufferSize, this);
	
	    bufferSize = Math.min(bufferSize, k);
	    return Collections.unmodifiableList(
	        Arrays.asList(ObjectArrays.arraysCopyOf(buffer, bufferSize)));
	    // We can't use ImmutableList; we have to be null-friendly!
	  }
	
	  private <E extends T> int partition(
	      E[] values, int left, int right, int pivotIndex) {
	    E pivotValue = values[pivotIndex];
	
	    values[pivotIndex] = values[right];
	    values[right] = pivotValue;
	
	    int storeIndex = left;
	    for (int i = left; i < right; i++) {
	      if (compare(values[i], pivotValue) < 0) {
	        ObjectArrays.swap(values, storeIndex, i);
	        storeIndex++;
	      }
	    }
	    ObjectArrays.swap(values, right, storeIndex);
	    return storeIndex;
	  }


#### 源码分析  ####
1.2.3.1 当k满足(k >= Integer.MAX_VALUE / 2)时，采用“straightforward sorted-copy-and-sublist”，直接排序-复制和取子串的方式操作  
其中排序算法直接调用 Collections.sort(list, this)，而其又调用  Arrays.sort(a, (Comparator)c);  

Arrays.sort源码：

	  public static <T> void sort(T[] a, Comparator<? super T> c) {
	        if (LegacyMergeSort.userRequested)
	            legacyMergeSort(a, c);
	        else
	            TimSort.sort(a, c);
	    }
legacyMergeSort方法为传统的归并排序，当分到小于INSERTIONSORT_THRESHOLD（代码中设为7）时，采用插入排序，当大于INSERTIONSORT_THRESHOLD时采用归并排序，代码可见：java.util.Arrays#mergeSort(java.lang.Object[], java.lang.Object[], int, int, int)，不详细讲

Array的sort方法中还提供年了TimSort：
	
	 TimSort.sort(a, c);

 具体采用的是Tim Peters's list sort for Python
      (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
      TimSort</a>). 

1.2.3.2 当k < Integer.MAX_VALUE / 2时，新建一个buffer，大小为2*k，当buffer元素小于k且有元素时，直接插入：

    while (bufferSize < k && elements.hasNext()) {
      E e = elements.next();
      buffer[bufferSize++] = e;
      threshold = max(threshold, e);
    }
threshold取max，max不一定是最大值，里面调用了compare，compare方法重写了，所以需要根据实际情况分析，top方法默认的max是取最小值 
 
当buffer中元素多于k时，则与threshold比较，如果campare结果符合才插入，当buffer元素达到2*k时，会调用 quickselect algorithm 即快速选择算法，取buffer符合要求的前k个，实际没有删除，而是移动元素，将符合的放在buffer中的前k个，后k个后面可能会被覆盖。  
 
**1.2.3.2.1 quickselect algorithm**  
 quickselect algorithm 大致思路是去中间值作为划分界限，然后遍历buffer中元素，compare符合的放在k前面，不符合的放在k后面，里面会调用partition去操作，并且返回中间值移动后的位置storeIndex，然后将该位置storeIndex再与比较k比较，如果大于k，则在left到storeIndex间继续partition操作，如果storeIndex小于k，则在storeIndex到right间partition操作，否则正好符合要求

#### 1.2.3.3 返回 ####
最后在Arrays.sort方法，对buffer中的元素进行排序，最后取k个，copy返回

	Arrays.sort(buffer, 0, bufferSize, this);

    bufferSize = Math.min(bufferSize, k);
    return Collections.unmodifiableList(
        Arrays.asList(ObjectArrays.arraysCopyOf(buffer, bufferSize)));


# 2.代码： #

## （1）使用 ##
取最大的topK：

	val nums = Array(4,5,3,2,1,6,7,9,8,10)
    val ints = sc.makeRDD(scala.util.Random.shuffle(nums), 2)
    val topK = ints.top(5)
    topK.foreach(println)
    assert(topK.size === 5)
	
输出：

	10
	9
	8
	7
	6

取最小的topK：

  	val nums = Array(4,5,3,2,1,6,7,9,8,10)
    implicit val ord = implicitly[Ordering[Int]].reverse
    val ints = sc.makeRDD(scala.util.Random.shuffle(nums), 2)
    val topK = ints.top(5)
    topK.foreach(println)

输出：

	1
	2
	3
	4
	5

每个细节可以debug具体去看

# 3.结果： #

样例运行成功，top方法基本理解，有几个疑问：

3.1 为什么reduce结果toArray后要sorted？reduce返回的是有界的BoundedPriorityQueue对象，而且有序，为什么不用reverse操作，复杂度更低？  
可能情况：保证结果稳定？

代码：org.apache.spark.rdd.RDD#takeOrdered

	  mapRDDs.reduce { (queue1, queue2) =>
          queue1 ++= queue2
          queue1
        }.toArray.sorted(ord)

spark-2.0.1修改RDD的takeOrdered的sorted之后会报错：结果无序

	Array(9, 10, 7, 8, 6) did not equal Array(10, 9, 8, 7, 6)
	ScalaTestFailureLocation: org.apache.spark.rdd.RDDSuite$$anonfun$52 at (RDDSuite.scala:656)
	org.scalatest.exceptions.TestFailedException: Array(9, 10, 7, 8, 6) did not equal Array(10, 9, 8, 7, 6)



3.2 快排中为什么用2*k的buffer？为什么不直接用有界的优先队列？这样操作也简单，时间也更低？
可能情况：避免极端情况？值相同的有多个；k比较大时维护有界的成本较大？

代码：com.google.common.collect.Ordering#leastOf(java.util.Iterator<E>, int)

    int bufferCap = k * 2;
    @SuppressWarnings("unchecked") // we'll only put E's in
    E[] buffer = (E[]) new Object[bufferCap];
    E threshold = elements.next();
    buffer[0] = threshold;
    int bufferSize = 1;

参考

	【1】http://spark.apache.org/
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:《深入理解spark核心思想与源码分析》
    【5】book:《spark核心源码分析和开发实战》
