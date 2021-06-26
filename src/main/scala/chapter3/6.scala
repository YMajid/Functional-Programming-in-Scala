import chapter3._
import collection.mutable.ListBuffer

def init[A](list: List[A]): List[A] = {
  list match {
    case Nil => sys.error("Invalid: Empty List")
    case Cons(_, Nil) => Nil
    case Cons(h, t) => Cons(h, init2(t))
  }
}

// Copy each element except for the last one into a new list, and return that!
def init2[A](list: List[A]): List[A] = {
  val listBuffer = new ListBuffer[A]

  @annotation.tailrec
  def go(currList: List[A]): List[A] = {
    currList match {
      case Nil => sys.error("Invalid: Empty List")
      case Cons(_, Nil) => List(listBuffer.toList: _*)
      case Cons(h, t) => listBuffer += h; go(t)
    }
  }

  go(list)
}