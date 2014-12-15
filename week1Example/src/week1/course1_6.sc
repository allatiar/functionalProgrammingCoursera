package week1 {
  object session {
    1 + 3                                         //> res0: Int(4) = 4

    def abs(x: Double) = if (x < 0) -x else x     //> abs: (x: Double)Double

    println("Welcome to the Scala worksheet")     //> Welcome to the Scala worksheet

    def sqrt(x: Double) = {
      def sqrtIter(guess: Double): Double =
        if (isGoodEnough(guess)) guess
        else sqrtIter(improve(guess))

      def isGoodEnough(guess: Double) = abs(guess * guess - x) / x < 0.0001

      def improve(guess: Double) = (guess + x / guess) / 2
      
      sqrtIter(1.0)
    }                                             //> sqrt: (x: Double)Double

    sqrt(2)                                       //> res1: Double = 1.4142156862745097
    sqrt(4)                                       //> res2: Double = 2.0000000929222947
    sqrt(0.001)                                   //> res3: Double = 0.03162278245070105
    sqrt(0.1e-20)                                 //> res4: Double = 3.1622778383672726E-11
    sqrt(1.0e20)                                  //> res5: Double = 1.0000021484861237E10
    sqrt(1.0e50)                                  //> res6: Double = 1.0000003807575104E25

  }
  
}

//Lecture 1.6