import chapter3._

def tail[A](inputList: List[A]): List[A] = {
  inputList match {
    case Cons(_, y) => y
    case _ => Nil
  }
}