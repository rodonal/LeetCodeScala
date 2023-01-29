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

}
