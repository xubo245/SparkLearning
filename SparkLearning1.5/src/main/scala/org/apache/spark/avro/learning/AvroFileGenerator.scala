package org.apache.spark.avro.learning

import org.apache.avro.Schema
import java.io.File
import org.apache.avro.file.DataFileWriter
import org.apache.avro.generic.GenericDatumWriter
import org.apache.avro.generic.GenericRecord
import java.text.SimpleDateFormat
import java.util.Date

object AvroFileGenerator {

  def main(args: Array[String]): Unit = {
    val schemaPath = "file/data/avro/input/benchmarkSchema.avsc"
    val outputDir = "file/data/avro/output/avroForBenchmark/"
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS")
      .format(new Date());
    val schema = new Schema.Parser().parse(new File(schemaPath))
    val outputFile = new File(outputDir + "part" + iString + ".avro")
    val datumWriter = new GenericDatumWriter[GenericRecord](schema)
    val dataFileWriter = new DataFileWriter[GenericRecord](datumWriter)
    dataFileWriter.create(schema, outputFile)
    println(schema);
    println("end");
  }

}