// An example of how a case class might be implemented by hand.


// Companion object.
object Address {
  // Factory method.
  def apply(street: String, number: Int) =
    new Address(street, number)

  // Extractor.
  // This extractor will always succeed. The double parentheses below are
  // to disambiguate calling Some with two parameters versus calling it with
  // one tuple.
  def unapply(address: Address): Option[(String, Int)] =
    Some((address.street, address.number))
}

// Prefix all parameters with 'val'.
class Address(val street: String, val number: Int) extends Equals {

  // "Natural" implementation of toString (based on class name and parameter
  // values.
  override def toString = s"Address($street, $number)"

  // "Natural" implementations of hashCode and equals (based on class name and
  // parameter values.
  def canEqual(other: Any) = {
    other.isInstanceOf[Address]
  }

  override def equals(other: Any) = {
    other match {
      case that: Address => that.canEqual(Address.this) && street == that.street && number == that.number
      case _ => false
    }
  }

  override def hashCode() = {
    val prime = 41
    prime * (prime + street.hashCode) + number.hashCode
  }
}
