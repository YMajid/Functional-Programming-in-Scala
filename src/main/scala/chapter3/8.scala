import chapter3._
import collection.mutable.ListBuffer

/*
 * val res1: List[Int] = Cons(1,Cons(2,Cons(3,Nil)))
 * Returns the same list. All it "does" is replace the `Nil` constructor with the `x` argument, and it replaces the `Cons` constructor with the given function, `f`.
 * If we just supply `Nil` for `x` and `Cons` for `f`, then we get back the input list.
 */ 
foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_))

