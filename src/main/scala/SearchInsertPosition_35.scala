import scala.annotation.tailrec
object SearchInsertPosition_35 extends App {

  def searchInsert(nums: Array[Int], target: Int): Int = {

    @tailrec
    def searchInserHelper(
        nums: Array[Int],
        target: Int,
        lowerIndex: Int,
        upperIndex: Int
    ): Int = {

      if (lowerIndex > upperIndex) return lowerIndex

      val mid = lowerIndex + (upperIndex - lowerIndex) / 2

      nums(mid) match {
        case currentNumber if currentNumber == target => mid
        case currentNumber if currentNumber < target =>
          searchInserHelper(nums, target, mid + 1, upperIndex)
        case _ => searchInserHelper(nums, target, lowerIndex, mid - 1)
      }

    }

    searchInserHelper(nums, target, 0, nums.length - 1)
  }

}
