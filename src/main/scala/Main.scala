package matrixsort

object Main {

  def main(args: Array[String]): Unit = {
    val intList: Array[Int] = args.headOption match {
      case Some(s:String) => s.split(",").map(_.toInt)
      case None => Array(0)
    }
    val (target: Int, count: Int) = (args.tail.head.toInt, args.tail.tail.head.toInt) // Make safe
    val result = outerTuple(intList.toList, target, count)
    println(s"Achieved Value: ${result.value} by adding ${result.parts(0)} and ${result.parts(1)}")
  }



  case class AnswerInfo(value: Int, parts: List[Int])
  def outerTuple(list: List[Int], targetValue: Int, n: Int): AnswerInfo = {
    val parts = list.sorted.reverse.zipWithIndex.partition(x => x._2 % 2 == 0)
    val x: List[Int] = parts._1.map(x => x._1)
    val y: List[Int] = parts._2.map(x => x._1)
    val sum = x.mkString.toInt + y.mkString.toInt
    AnswerInfo(value = sum, parts = List(x.mkString.toInt, y.mkString.toInt))
  }
}