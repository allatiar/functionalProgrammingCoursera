package objsets
import objsets._
object worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val set1 = new Empty                            //> set1  : objsets.Empty = objsets.Empty@3ef8dcfe
  val set2 = set1.incl(new Tweet("a", "a body", 20))
                                                  //> set2  : objsets.TweetSet = objsets.NonEmpty@225ac214
  val set3 = set2.incl(new Tweet("b", "b body", 20))
                                                  //> set3  : objsets.TweetSet = objsets.NonEmpty@72d9ceea
  val c = new Tweet("c", "c body", 7)             //> c  : objsets.Tweet = User: c
                                                  //| Text: c body [7]
  val d = new Tweet("d", "d body", 9)             //> d  : objsets.Tweet = User: d
                                                  //| Text: d body [9]
  val set4c = set3.incl(c)                        //> set4c  : objsets.TweetSet = objsets.NonEmpty@399f9f8e
  val set4d = set3.incl(d)                        //> set4d  : objsets.TweetSet = objsets.NonEmpty@1ea44130
  val set5 = set4c.incl(d)                        //> set5  : objsets.TweetSet = objsets.NonEmpty@31b3c607

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }                                               //> asSet: (tweets: objsets.TweetSet)Set[objsets.Tweet]

  def size(set: TweetSet): Int = asSet(set).size  //> size: (set: objsets.TweetSet)Int

  size(set2.filter(tw => tw.user == "a"))         //> res0: Int = 1
  }