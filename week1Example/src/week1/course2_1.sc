package week1

object course1_7 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int

  def sum2(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum2(f)(a + 1, b)
  }                                               //> sum2: (f: Int => Int)(a: Int, b: Int)Int

  sum(x => x * x)(3, 5)                           //> res0: Int = 50
  sum2(x => x * x)(3, 5)                          //> res1: Int = 50

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x * x)(3, 4)                       //> res2: Int = 144

  def factorial(n: Int) = product(x => x)(1, n)   //> factorial: (n: Int)Int

  factorial(1)                                    //> res3: Int = 1
  factorial(2)                                    //> res4: Int = 2
  factorial(3)                                    //> res5: Int = 6
  factorial(4)                                    //> res6: Int = 24

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int

  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
  product2(x => x * x)(3, 4)                      //> res7: Int = 144

}