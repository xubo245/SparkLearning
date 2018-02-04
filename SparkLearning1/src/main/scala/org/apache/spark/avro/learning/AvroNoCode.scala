package org.apache.spark.avro.learning

import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import org.apache.avro.Schema
import org.apache.avro.file.DataFileReader
import org.apache.avro.file.DataFileWriter
import org.apache.avro.generic.GenericData
import org.apache.avro.generic.GenericDatumReader
import org.apache.avro.generic.GenericDatumWriter
import org.apache.avro.generic.GenericRecord

object AvroNoCode {

  def main(args: Array[String]): Unit = {
    val schema = new Schema.Parser().parse(new File(
      "file/data/avro/input/user.avsc"));
    val user1 = new GenericData.Record(schema);
    println(user1);
    user1.put("name", "Alyssa");
    user1.put("favorite_number", 256);

    val user2 = new GenericData.Record(schema);
    user2.put("name", "Ben");
    user2.put("favorite_number", 7);
    user2.put("favorite_color", "red");

    println("create user:");
    println(user1);
    println(user2);

    // Serialize user1 and user2 to disk
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS")
      .format(new Date());
    val file = new File("file/data/avro/output/avro/users" + iString + ".avro");
    val datumWriter = new GenericDatumWriter[GenericRecord] (
      schema);
    val dataFileWriter = new DataFileWriter[GenericRecord] (
      datumWriter);
    dataFileWriter.create(schema, file);
    dataFileWriter.append(user1);
    dataFileWriter.append(user2);
    dataFileWriter.close();

    // Deserialize users from disk
    val datumReader = new GenericDatumReader[GenericRecord] (
      schema);
   val dataFileReader = new DataFileReader[GenericRecord] (
      file, datumReader);
;
    var  user = null:GenericRecord;
    while (dataFileReader.hasNext()) {
      // Reuse user object by passing it to next(). This saves us from
      // allocating and garbage collecting many objects for files with
      // many items.
      user = dataFileReader.next(user);
      println(user);
    }

    println("end");
  }

}