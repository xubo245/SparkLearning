package test

object test1 {
  def main(args:Array[String]){
  var sum:BigDecimal=1.0
  var k=0
  for(i<-1 to 100) {
    if(sum>100000000){
      sum=sum/100000000
      k=k+8
    }
    sum=sum*i
  }
  println(sum+":"+k);
  }
 
}