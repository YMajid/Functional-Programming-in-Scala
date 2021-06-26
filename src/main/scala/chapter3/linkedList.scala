package chapter3

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(nums: List[Int]): Int = {
    nums match {
      case Nil => 0
      case Cons(x, y) => x + sum(y)
    }
  }

  def product(nums: List[Double]): Double = {
    nums match {
      case Nil => 1.0
      case Cons(0, _) => 0.0
      case Cons(x, y) => x * product(y)
    }
  }

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }
}