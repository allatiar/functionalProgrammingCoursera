package patmat
import Huffman._
 
object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  var clist = List('a','b','c','b','a','b')       //> clist  : List[Char] = List(a, b, c, b, a, b)
var result = times(clist)                         //> result  : List[(Char, Int)] = List((a,2), (b,3), (c,1))
var leafList = makeOrderedLeafList(result)        //> leafList  : List[patmat.Huffman.Leaf] = List(Leaf(c,1), Leaf(a,2), Leaf(b,3)
                                                  //| )
combine(leafList)                                 //> res0: List[patmat.Huffman.CodeTree] = List(Fork(Leaf(c,1),Leaf(a,2),List(c, 
                                                  //| a),3), Leaf(b,3))

decodedSecret                                     //> res1: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)

  
}