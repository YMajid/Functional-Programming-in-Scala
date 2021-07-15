import chapter3._
import collection.mutable.ListBuffer

def sum3(as: List[Int]): Int = {
  foldLeft(as, 0)(_+_)
}

def product3(as: List[Double]): Double = {
  foldLeft(as, 1.0)(_*_)
}

def length3(as: List[Int]): Int = {
  foldLeft(as, 0)((len, _) => len + 1)
}
