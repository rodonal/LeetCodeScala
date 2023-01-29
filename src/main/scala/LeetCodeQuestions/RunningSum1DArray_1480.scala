package LeetCodeQuestions

object RunningSum1DArray_1480 {

  def runningSum(nums: Array[Int]): Array[Int] = {
    val runningSumArray = new Array[Int](nums.length)
    var currentTotal = 0

    for (i <- 0 to (runningSumArray.length - 1)) {
      currentTotal += nums(i)
      runningSumArray(i) += currentTotal

    }
    runningSumArray
  }

  def runningSumFunctional(nums: Array[Int]): Array[Int] = {
    val runningSumArray =  nums.scanLeft(0)((x,y) => x+y).tail
    runningSumArray
  }

}
