package chapter3
import scala.annotation.tailrec

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
      case Cons(x, y) => x * product(y)
    }
  }

  def apply[A](as: A*): List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  /*
  Code for `sum` and `product` is almost exactly the same, except that when we encounter `Nil` in `sum` we return 0 and in `product` we return 1.0, and the former uses the `+` operator while the latter uses `*`.
  To avoid this duplication of code, we can generalize it away by pulling the subexpressions out into function arguments.
  If the subexpression refers to any local variables, turn the subexpression into a function that accepts these variables as arguments.
   */
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(x, y) => f(x, foldRight(y, z)(f))
    }
  }

  def sum2(ns: List[Int]): Int = {
    foldRight(ns, 0)(_ + _)
  }

  def product2(ns: List[Double]): Double = {
    foldRight(ns, 1.0)(_ * _)
  }

  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case Cons(h, t) => foldLeft(t, f(z, h))(f)
    }
  }
  
  def sum3(as: List[Int]): Int = {
    foldLeft(as, 0)(_+_)
  }

  def product3(as: List[Double]): Double = {
    foldLeft(as, 1)(_*_)
  }

  def length3(as: List[Int]): Int = {
    foldLeft(as, 0)((len, _) => len + 1)
  }
}
