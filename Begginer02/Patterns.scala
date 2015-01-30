// As first seen on https://gist.github.com/tferega/21af1f7ab68806845fed

// Implementation of insertion sort with lists and pattern matching.
object ISort {
  def sort(l: List[Int]): List[Int] = {
    l match {
      case Nil => Nil
      case head :: tail => insert(head, sort(tail))
    }
  }
  
  def insert(x: Int, l: List[Int]): List[Int] = {
    l match {
      case Nil => List(x)
      case head :: tail => 
        if (x <= head) {
          x :: l
        } else {
          head :: insert(x, tail)
        }
    }
  }
}


def typedMatch(x: Any) {
  x match {
    case s: String => println("Text: " + s)
    case c: Char   => println("Character: " + c)
    case _: Int    => println("A number, any number!")
    case _         => println("Anything, anything at all!")
  }
}

val MagicNumber = 50
def intMatch(i: Int, special: Int) {
  i match {
    case 9001        => println("A literal value over nine thounsand!")
    case MagicNumber => println("A magic number!")
    case 5 | 3       => println("Either five or three!")
    case `special`   => println("A special number!")
  }
}

def conditionalMatch(s: String) {
  s match {
    case x if x.length > 10 => println("A long string")
    case x if x.startsWith("asdf") => println("""String starting with "asdf"!""")
  }
}

def listMatch(l: List[Int]) {
  l match {
    case Nil => println("An empty list!")
    case head :: Nil => println("A list with one element (%d)" format head)
    case e1 :: e2 :: e3 :: Nil => println("A list with three elements (%d, %d, %d)".format(e1, e2, e3))
    case head :: tail => println("A longer list!")
  }
}
