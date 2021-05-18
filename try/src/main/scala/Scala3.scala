object Scala3 {
  //scala3
  object scala3 {

    // a type class
    trait Printer[A]:
      extension (a: A) def print: String

    case class Person1(firstName: String, lastName: String)
    case class Person2(fullname: String)

    given Printer[Person1] with
      extension (p: Person1)
        def print: String =
          s"${p.firstName} ${p.lastName}"

    given Printer[Person2] with
      extension (p: Person2)
        def print: String =
          s"${p.fullname}"
  }
}
