package org.apache.spark.ml.Example;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xingyun.xb
 * @version $Id: Pipeline.java, v 0.1 2016-07-23 18:06 xingyun.xb Exp $
 */
public class test {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("Simple Application").setMaster("local[4]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);

        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> distData = sc.parallelize(data);

        System.out.println(distData.count());

        sc.stop();
    }
}