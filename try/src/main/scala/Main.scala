//scala
object Test {
  trait Person
  case class Person1(person1: String) extends Person
  case class Person2(person2: String, word: String) extends Person

  trait PersonPrinter[A <: Person] {
    def print(person: A): Unit
  }
  implicit object Person1Printer extends PersonPrinter[Person1] {
    override def print(person: Person1): Unit = {
      println(person.person1)
    }
  }
  implicit object Person2Printer extends PersonPrinter[Person2] {
    override def print(person: Person2): Unit = {
      println(person.person2 + person.word)
    }
  }

  def printer[A](person: A)(implicit printer: PersonPrinter[A]): Unit = {
    printer.print(person)
  }
  def main(args: Array[String]): Unit = {
    val person = Person2("test2", "word")
    printer(person)
  }
}

//java
sealed trait Person {
  def print()
}
class Person1(person1: String) extends Person {
  override def print(): Unit = {
    println(person1)
  }
}
class Person2(person2: String, word: String) extends Person {
  override def print(): Unit = {
    println(person2 + word)
  }
}
