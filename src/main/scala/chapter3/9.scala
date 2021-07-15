import chapter3._
import collection.mutable.ListBuffer

/*
 * Use a lambda function; pass in the array and a length variable. Keep on incrementing the variable by 1.
 */
def length[A](as: List[A]): Int = {
  foldRight(as, 0)((_, len) => len + 1)
}
