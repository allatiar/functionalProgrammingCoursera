package week1

object course1_7 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc*n, n-1)
    loop(1, n)
  }                                               //> factorial: (n: Int)Int
  
  factorial(0)                                    //> res0: Int = 1
  factorial(1)                                    //> res1: Int = 1
  factorial(2)                                    //> res2: Int = 2
  factorial(3)                                    //> res3: Int = 6
  factorial(4)                                    //> res4: Int = 24
  
}