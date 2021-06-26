import chapter3._

def setHead[A](newHead: A, list: List[A]): List[A] = {
  list match {
    case Cons(_, y) => Cons(newHead, y)
    case _ => Cons(newHead, Nil)
  }
}