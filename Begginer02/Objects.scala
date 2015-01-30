// Companion object to Person class.
object Person {
  // A helper function.
  def parse(s: String): Person = {
    val nameArr = s.split(" ")
    new Person(nameArr(0), nameArr(1))
  }
}

// A class with companion object.
class Person(val firstName: String, val familyName: String) {
  val fullName: String = s"$firstName $familyName"
}

// Example of an Object extending an instance of a class.
object TheCaptian extends Person("James", "Kirk")

object Objects extends App {
  val me = Person.parse("Tomo Ferega")
  println(TheCaptain.fullName)
  println(a.fullName)
}
