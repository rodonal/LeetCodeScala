package ScalaTricks


//https://stackoverflow.com/questions/17408880/reduce-fold-or-scan-left-right
object Scan extends App {
  println("Scan")

  /**

  In general, all 6 fold functions apply a binary operator to each element of a collection. The result of each step is passed on to the next step (as input to one of the binary operator's two arguments). This way we can cumulate a result.

    reduceLeft and reduceRight cumulate a single result.

    foldLeft and foldRight cumulate a single result using a start value.

    scanLeft and scanRight cumulate a collection of intermediate cumulative results using a start value.

  **/


  val abc = List("A", "B", "C")
  def addLeft(res:String,x:String):String = {
    println(s"op: $res + $x = ${res+x}")
    res + x
  }

  abc.scanLeft("z")(addLeft)
  // op: z + A = zA      // same operations as foldLeft above...
  // op: zA + B = zAB
  // op: zAB + C = zABC
  // res: List[String] = List(z, zA, zAB, zABC) // maps intermediate results

  /**
  From RIGHT and backwards...
  If we start with the RIGHT element and go backwards (from C to A) we'll notice that now the second argument

  to our binary operator accumulates the result (the operator is the same, we just switched the argument names

  to make their roles clear):

   */

  def addRight(x: String, res: String) = {
    println(s"op: $x + $res = ${x + res}")
    x + res
  }

  abc.scanRight("z")(addRight)
  // op: C + z = Cz
  // op: B + Cz = BCz
  // op: A + BCz = ABCz
  // res: List[String] = List(ABCz, BCz, Cz, z)

}
