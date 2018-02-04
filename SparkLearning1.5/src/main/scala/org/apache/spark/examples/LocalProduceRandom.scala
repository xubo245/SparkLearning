/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
//package org.apache.spark.examples

//package org.apache.spark.examplesByXubo package org.apache.spark.examplesByXubo
package org.apache.spark.examples
import org.apache.spark._
import org.apache.spark.SparkContext._
import java.io.PrintWriter
import java.io.File
import java.util._
import java.text.SimpleDateFormat
//import org.apache.spark.SparkConf

object LocalProduceRandom {
  def main(args: Array[String]) {
    val n = 100000
    val m = 100
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val soutput = "file/data/examples/output/" + iString;
    val w1 = new PrintWriter(new File("file/data/examples/output/output" + iString + ".txt"))
    var uu = new Random()
    for (i <- 1 to n) { w1.println(uu.nextInt(m)) }
    println("success")
    w1.close()

    //    var count = 0
    //    for (i <- 1 to n) {
    ////      val x = random * 2 - 1
    ////      val y = random * 2 - 1
    ////      if (x*x + y*y < 1) count += 1
    //    }
    //    println("Pi is roughly " + 4 * count / 100000.0)
  }
}
// scalastyle:on println
