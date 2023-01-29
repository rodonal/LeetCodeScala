package LeetCodeQuestions

import scala.annotation.tailrec

object BinarySearch_704 extends App {

  //Takeways:
  // import tailrec -> import scala.annotation.tailrec
  //arr.length -> length of an array
  // use return in special cases
  // always looking for pattern matching usage

  def search(nums: Array[Int], target: Int): Int = {
    @tailrec
    def binarySearchHelper(
        nums: Array[Int],
        target: Int,
        lowerIndex: Int,
        upperIndex: Int
    ): Int = {
      if (lowerIndex > upperIndex) return -1
      val mid = (upperIndex - lowerIndex) / 2 + lowerIndex
      nums(mid) match {
        case currentValue if currentValue == target => mid
        case currentValue if currentValue < target =>
          binarySearchHelper(nums, target, mid + 1, upperIndex)
        case _ => binarySearchHelper(nums, target, lowerIndex, mid - 1)
      }

    }

    binarySearchHelper(nums, target, 0, nums.length - 1)
  }

}
