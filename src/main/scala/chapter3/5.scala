import chapter3._

def dropWhile[A](list: List[A], func: A => Boolean): List[A] = {
  list match {
    case Cons(x, y) => if (func(x)) dropWhile(y)(func)
    case _ => list
  }
}