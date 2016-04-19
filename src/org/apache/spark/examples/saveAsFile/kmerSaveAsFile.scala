/**
 * @author xubo
 * need adam jar :
 * https://github.com/bigdatagenomics/adam
 */
package org.apache.spark.examples.saveAsFile
import org.apache.spark._
import org.bdgenomics.adam.rdd.ADAMContext
import org.bdgenomics.adam.projections.{AlignmentRecordField, Projection}
import java.text.SimpleDateFormat
import java.util._;

object kmerSaveAsFile{
def main(args:Array[String]){
  val conf=new SparkConf().setAppName("test Adam kmer").setMaster("local")
//  val conf=new SparkConf().setAppName("test Adam kmer").setMaster("local")
//  val conf=new SparkConf().setAppName("test Adam kmer")
  val sc=new SparkContext(conf)
val ac = new ADAMContext(sc)
// Load alignments from disk
//val reads = ac.loadAlignments("/data/NA21144.chrom11.ILLUMINA.adam",
//  val reads = ac.loadAlignments("/xubo/adam/output/small.adam",
val reads = ac.loadAlignments("file/data/examples/input/small.adam",
  projection = Some(Projection(AlignmentRecordField.sequence,AlignmentRecordField.readMapped,AlignmentRecordField.mapq)))
// Generate, count and sort 21-mers
val kmers =reads.flatMap(_.getSequence.sliding(21).map(k => (k, 1L))).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false)
kmers.take(10).foreach(println)

//
 val iString=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date() )
 val soutput="file/data/examples/output/kmer/"+iString+"/smallkmers21.adam";
  
println("kmers.count(reduceByKey):"+kmers.count)
kmers.saveAsTextFile(soutput)
val sum0=for((a,b)<-kmers) yield a
println("kmers.count(no reduce):"+sum0.sum)
sc.stop()
// Print the top 10 most common 21-mers
}
}