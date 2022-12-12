import scala.annotation.tailrec

object SquaresOfSortedArray extends App {


  //Borrowed solution, simply splendid
  //Takeaways: Tail recursion instead of for loops
  // Two Pointers solution
  def sortedSquares(nums: Array[Int]): Array[Int] = {
    @tailrec
    def sortedSquaresHelper(lowerIndex: Int, upperIndex: Int, r: List[Int]): List[Int] = {
      if(lowerIndex <= upperIndex) {
        val leftSq  = nums(lowerIndex) * nums(lowerIndex)
        val rightSq = nums(upperIndex) * nums(upperIndex)
        if(leftSq > rightSq) sortedSquaresHelper(lowerIndex+1, upperIndex, leftSq :: r)
        else sortedSquaresHelper(lowerIndex, upperIndex-1, rightSq :: r)
      } else
        r
    }
    sortedSquaresHelper(0, nums.length-1, List.empty).toArray
  }
  println(sortedSquares(Array(-3,-2,0,1,4,5)).mkString(","))

}
