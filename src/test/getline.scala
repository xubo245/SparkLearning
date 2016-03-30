package test

import scala.io.Source

object getline extends App {
var text1=Source.fromFile("git.txt")
var a=text1.getLines
var i=1
while(a.hasNext){
  println(i+":"+a.next)
  i+=1
}
}