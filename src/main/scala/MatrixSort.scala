package matrixsort

object MatrixSort {

  // Preserve origin information for later referral
  case class AnswerInfo(value: Int, parts: Tuple2[Int, Int])

  def main(args: Array[String]): Unit = {
    val result: AnswerInfo = tupleSum(stringToArrayInt(args.head))
    println(s"Achieved Value: ${result.value} by adding ${result.parts._1} and ${result.parts._2}")
  }


  // translate comma delimited string into array of ints
  def stringToArrayInt(input: String) = input.split(",").map(_.toInt)

  // Get the outer tuple list
  def outerTuple(list: List[Int]): (List[Int], List[Int]) = {
    val parts = list.sorted.reverse.zipWithIndex.partition(x => x._2 % 2 == 0)
    (parts._1.map(x => x._1), parts._2.map(x => x._1))
  }

  // Stringify and sum, return as AnswerInfo
  def tupleSum(input: Array[Int]): AnswerInfo = {
    val outer = outerTuple(input.toList)
    val sums = (outer._1.mkString.toInt, outer._2.mkString.toInt)
    AnswerInfo(value = sums._1 + sums._2, parts = sums)
  }
}