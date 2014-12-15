package week7

object testWeek7 {
  val problem = new Pouring(Vector(4,9,  19))     //> problem  : week7.Pouring = week7.Pouring@4ec44deb
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek7.testWeek7.problem.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0), F
                                                  //| ill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), Pour(
                                                  //| 2,1))
  
  problem.solution(17)                            //> res1: Stream[week7.testWeek7.problem.Path] = Stream(Fill(2) Pour(2,0) Pour(0
                                                  //| ,2)--> Vector(15, 0, 17), ?)
}