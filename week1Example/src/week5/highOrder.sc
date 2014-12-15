package week5

object highOrder {
  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => y * y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]

  val list = List(1, 2, 3, 4, 5)                  //> list  : List[Int] = List(1, 2, 3, 4, 5)
  squareList(list)                                //> res0: List[Int] = List(1, 4, 9, 16, 25)

  list map (i => i * i)                           //> res1: List[Int] = List(1, 4, 9, 16, 25)

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  nums filter (x => x > 0)                        //> res2: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res3: List[Int] = List(-4)
  nums partition (x => x > 0)                     //> res4: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))

  nums takeWhile (x => x > 0)                     //> res5: List[Int] = List(2)
  nums dropWhile (x => x > 0)                     //> res6: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res7: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))

  val test = List("a", "a", "a", "b", "c", "c", "a", "c")
                                                  //> test  : List[String] = List(a, a, a, b, c, c, a, c)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  pack(test)                                      //> res8: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a),
                                                  //|  List(c))

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))     //> encode: [T](xs: List[T])List[(T, Int)]

  encode(test)                                    //> res9: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1), (c,1))
  
    def sum(xs: List[Int]) = (0::xs) reduceLeft((x,y) => x+y)
                                                  //> sum: (xs: List[Int])Int
  list                                            //> res10: List[Int] = List(1, 2, 3, 4, 5)
  sum(list)                                       //> res11: Int = 15
  1::list reduceLeft (_*_)                        //> res12: Int = 120
  (list foldLeft 0) (_+_)                         //> res13: Int = 15
  //foldRight
  //reduceRight

}