package ScalaTricks

object Fold extends App {

  //1)
  println("Fold ,foldLeft, foldRight")
  //In essence, fold takes data in one format and gives it back to you in another
  val numbers = List(5, 4, 8, 6, 2)
  numbers.fold(0) { (i, j) =>
    i + j
  }
  println(numbers)
  //Signature of fold :  def fold[A1 >: A](z: A1)(op: (A1, A1) => A1): A1
  //The fold method for a List takes two arguments; the start value and a function

  //2)

  class Foo(val name: String, val age: Int, val sex: Symbol) {
    override def toString: String =
      s"name: $name ,age: $age,sex: $sex \n"
  }

  object Foo {
    def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)

  }

  val fooList = Foo("Hugh Jass", 25, Symbol("male")) ::
    Foo("Biggus Dickus", 43, Symbol("male")) ::
    Foo("Incontinentia Buttocks", 37, Symbol("female")) ::
    Nil

  println(fooList)

  //foldLeft start from beginning to end, foldRight starts from end to the beginning
  val stringList = fooList.foldLeft(List[String]()) { (z, f) =>
    val title = f.sex match {
      case Symbol("male")   => "Mr."
      case Symbol("female") => "Mrs."
    }
    z :+ s"$title ${f.name}, ${f.age}"
  }

  println(stringList)

  //Another example

  /**

  In general, all 6 fold functions apply a binary operator to each element of a collection. The result of each step is passed on to the next step (as input to one of the binary operator's two arguments). This way we can cumulate a result.

    reduceLeft and reduceRight cumulate a single result.

    foldLeft and foldRight cumulate a single result using a start value.

    scanLeft and scanRight cumulate a collection of intermediate cumulative results using a start value.

   **/

  val abc = List("A","B","C")

  def addLeft(res: String, x: String) = {
    println(s"op: $res + $x = ${res + x}")
    res + x
  }

  abc.foldLeft("z")(addLeft) // with start value "z"
  // op: z + A = zA      // initial extra operation
  // op: zA + B = zAB
  // op: zAB + C = zABC
  // res: String = zABC


  def addRight(x: String, res: String) = {
    println(s"op: $x + $res = ${x + res}")
    x + res
  }

  abc.foldRight("z")(addRight)
  // op: C + z = Cz
  // op: B + Cz = BCz
  // op: A + BCz = ABCz
  // res: String = ABCz


}
