package matrixsort

object Main {

  def main(args: Array[String]): Unit = {
    val intList: Array[Int] = args.headOption match {
      case Some(s:String) => s.split(",").map(_.toInt)
      case None => Array(0)
    }
    val (target: Int, count: Int) = (args.tail.head.toInt, args.tail.tail.head.toInt) // Make safe
    println(s"calling subset with ${intList} ${target}")
    println(subset(intList.toList, target, count))
  }



  def subset(list: List[Int], targetValue: Int, n: Int): List[List[Int]] = {
    // VERY N(O) heavy on large numbers, would be best with a stream
    val allCombos = list.permutations.toList.map(x => x.combinations(list.size / n))
    val items: List[List[Int]: allCombos.flatMap(_.sliding(n).sum)
  }
}