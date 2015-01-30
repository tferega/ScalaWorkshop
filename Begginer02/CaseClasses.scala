// Demonstrates some differences between plain classes and case classes.
class PlainAddress(street: String, number: Int)      // Plain class
case class CaseAddress(street: String, number: Int)  // Case class

object CaseClasses extends App {
  val plain1 = new PlainAddress("Stara", 10)
  val plain2 = new PlainAddress("Stara", 10)
  
  // Usless printout.
  println(plain1)
  
  // error: value street is not a member of PlainAddress
  // Because street is not marked with 'var' or 'val', and is private.
  println(plain1.street)
  
  // False, because the default equality implementation compares references.
  println(plain1 == plain2)
  
  // --------------------------------------------------------------------------
  
  val case1 = Address("Draškovićeva", 33)
  val case2 = Address("Draškovićeva", 33)
  
  // Nice printout, based in class name and argument values.
  println(elementAddr)
  
  // Prints the street, because it's implicitly prefixed with 'val'.
  println(elementAddr.street)
  
  // true, because case class implementation is based on argument values.
  println(elementAddr == workshopAddr)
}
