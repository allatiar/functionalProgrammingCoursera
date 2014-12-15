package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r == 0 || c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def open: Char = "(".charAt(0);
    def closed: Char = ")".charAt(0);

    def isBalanced(charStart: Char, charFinish: Char) =
      if (charStart == open) charFinish == closed
      else false

    def balanceIter(input: List[Char], stack: List[Char]): Boolean =
      if (input.isEmpty) stack.isEmpty
      else if (input.head == open) balanceIter(input.tail, input.head :: stack)
      else if (input.head == closed) !stack.isEmpty && isBalanced(stack.last, input.head) && balanceIter(input.tail, stack.init)
      else balanceIter(input.tail, stack)
    balanceIter(chars, "".toList)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeIter(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (coins.isEmpty || money < 0) 0
      else countChangeIter(money, coins.tail) + countChangeIter(money - coins.head, coins)
    }
    if (money == 0) 0
    else countChangeIter(money, coins)
  }
}
