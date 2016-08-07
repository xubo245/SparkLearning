
//package org.apache.spark.ml.Example;
//
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.rdd.RDD;
//import org.apache.spark.sql.SQLContext;
//
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.spark.ml.Pipeline;
//import org.apache.spark.ml.PipelineModel;
//import org.apache.spark.ml.PipelineStage;
//import org.apache.spark.ml.classification.LogisticRegression;
//import org.apache.spark.ml.feature.HashingTF;
//import org.apache.spark.ml.feature.Tokenizer;
//import org.apache.spark.sql.DataFrame;
//import org.apache.spark.sql.Row;
///**
// *
// * @author xingyun.xb
// * @version $Id: PipelineLearning.java, v 0.1 2016-07-23 18:10 xingyun.xb Exp $
// */
//public class PipelineLearning {
//    public static void main(String[] args) {
//        SparkConf conf = new SparkConf().setAppName("Simple Application").setMaster("local[4]");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
//
//
//
//// Prepare training documents, which are labeled.
//        DataFrame training = sqlContext.createDataFrame((JavaRDD<LabeledDocument>) Arrays.asList(
//                new LabeledDocument(0L, "a b c d e spark", 1.0),
//                new LabeledDocument(1L, "b d", 0.0),
//                new LabeledDocument(2L, "spark f g h", 1.0),
//                new LabeledDocument(3L, "hadoop mapreduce", 0.0)
//        ), LabeledDocument.class);
//
//// Configure an ML pipeline, which consists of three stages: tokenizer, hashingTF, and lr.
//        Tokenizer tokenizer = new Tokenizer()
//                .setInputCol("text")
//                .setOutputCol("words");
//        HashingTF hashingTF = new HashingTF()
//                .setNumFeatures(1000)
//                .setInputCol(tokenizer.getOutputCol())
//                .setOutputCol("features");
//        LogisticRegression lr = new LogisticRegression()
//                .setMaxIter(10)
//                .setRegParam(0.01);
//        Pipeline pipeline = new Pipeline()
//                .setStages(new PipelineStage[] {tokenizer, hashingTF, lr});
//
//// Fit the pipeline to training documents.
//        PipelineModel model = pipeline.fit(training);
//
//// Prepare test documents, which are unlabeled.
//        DataFrame test = sqlContext.createDataFrame((JavaRDD<?>) Arrays.asList(
//                new Document(4L, "spark i j k"),
//                new Document(5L, "l m n"),
//                new Document(6L, "mapreduce spark"),
//                new Document(7L, "apache hadoop")
//        ), Document.class);
//
//// Make predictions on test documents.
//        DataFrame predictions = model.transform(test);
//        for (Row r: predictions.select("id", "text", "probability", "prediction").collect()) {
//            System.out.println("(" + r.get(0) + ", " + r.get(1) + ") --> prob=" + r.get(2)
//                    + ", prediction=" + r.get(3));
//        }
//    }
//}
//
//
//// Labeled and unlabeled instance types.
//// Spark SQL can infer schema from Java Beans.
//class Document implements Serializable {
//    private long id;
//    private String text;
//
//    public Document(long id, String text) {
//        this.id = id;
//        this.text = text;
//    }
//
//    public long getId() { return this.id; }
//    public void setId(long id) { this.id = id; }
//
//    public String getText() { return this.text; }
//    public void setText(String text) { this.text = text; }
//}
//
//class LabeledDocument extends Document implements Serializable {
//    private double label;
//
//    public LabeledDocument(long id, String text, double label) {
//        super(id, text);
//        this.label = label;
//    }
//
//    public double getLabel() { return this.label; }
//    public void setLabel(double label) { this.label = label; }
//}