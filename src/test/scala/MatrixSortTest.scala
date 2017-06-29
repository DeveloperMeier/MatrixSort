package matrixsort

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by cheezy on 6/28/17.
  */
// Tests the case for only 2 numbers
class MatrixSortTest extends FlatSpec with Matchers {

  "stringToArrayInt" should "transform a comma delimited string into Array of Integers" in {
    assert(MatrixSort.stringToArrayInt("1,2,3,4,5,6").toList == List(1,2,3,4,5,6))
  }

  "outerTuple" should "only return the outermost tuples, which should be the closes do to partition" in {
    assert(MatrixSort.outerTuple(List(9, 8, 2, 5, 6, 1)) == (List(9,6,2), List(8,5,1)))
  }

  "tupleSum" should "transform an Array of integers and return an AnswerValue" in {
    val ints = Array(9, 8, 2,5,6,1)
    val answer = MatrixSort.tupleSum(ints)
    assert(answer.value == 1813)
    assert(answer.parts._1 == 962)
    assert(answer.parts._2 == 851)

  }


  // The only point of this test is to remind to try and make it work with double digits
  "bonusTest" should "should not handle 2 number digits very well" in {
    val ints = Array(11, 23, 1, 0, 5)
    val answer = MatrixSort.tupleSum(ints)
    assert(answer.value == 2461) // Very much the wrong value
    assert(answer.parts._1 == 2350) // Also makes no sense
    assert(answer.parts._2 == 111) // Also very wrong
  }


}
