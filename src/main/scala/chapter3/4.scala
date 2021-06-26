import chapter3._

def drop[A](n: Int, list: List[A]): List[A] = {
  if (n == 0) list
  else list match {
    case Cons(_, y) => drop(n - 1, y)
    case _ => Nil
  }
}