import scala.annotation.tailrec

def fib(n: Int): Int = {
  @tailrec
  def go(n: Int, prev: Int, curr: Int): Int = {
    if (n == 0) prev
    else go(n - 1, curr, prev + curr)
  }

  go(n, 0, 1)
}