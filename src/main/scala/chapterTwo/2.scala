import scala.annotation.tailrec

def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
  @tailrec
  def go(n: Int): Boolean = {
    if (n > as.length) true
    else if (ordered(as(n), as(n + 1))) false
    else go(n + 1)
  }

  go(0)
}