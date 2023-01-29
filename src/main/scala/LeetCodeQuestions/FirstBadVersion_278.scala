package LeetCodeQuestions

import scala.annotation.tailrec

object FirstBadVersion_278 {

  /* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */
  def isBadVersion(i: Int): Boolean = ???

  def firstBadVersion(n: Int): Int = {

    //Notes: Boolean. true,false not True ,False
    //Dont forget putting : ReturnType= {} as method's signature
    @tailrec
    def firstBadVersionHelper(
        lowerIndex: Int,
        upperIndex: Int,
        lowerIndexBoolean: Boolean,
        upperIndexBoolean: Boolean
    ): Int = {

      if (lowerIndex == upperIndex) return upperIndex

      val midIndex = lowerIndex + (upperIndex - lowerIndex) / 2
      val midIndexBoolean = isBadVersion(midIndex)

      (lowerIndexBoolean, midIndexBoolean, upperIndexBoolean) match {
        case (true, true, true) => return lowerIndex
        case (false, false, true) =>
          firstBadVersionHelper(
            midIndex + 1,
            upperIndex,
            isBadVersion(midIndex + 1),
            true
          )
        case (false, true, true) =>
          firstBadVersionHelper(
            lowerIndex + 1,
            midIndex,
            isBadVersion(lowerIndex + 1),
            true
          )
        case _ => -1 //In principle we should not get here

      }

    }

    firstBadVersionHelper(1, n, isBadVersion(1), isBadVersion(n))

  }

}
