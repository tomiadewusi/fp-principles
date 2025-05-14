package recfun

import scala.annotation.tailrec

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if c ==0 || c==r then 1 else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
  // you want to check if all parentheses are valid
  // valid  == true, invalid == false
  // openCount keeps track of the number of '('
  // you +openCount for '(' and -openCount for ')'
  // loop is a tail recursive helper function
    @tailrec
    def loop(remaining: List[Char], openCount: Int): Boolean =
      // base case
      if openCount < 0 then false
      else if remaining.isEmpty then openCount == 0
      // recursive case
      else
        val head = remaining.head
        val tail = remaining.tail
        val nextOpen =
          if head == '(' then openCount + 1
          else if head == ')' then openCount -1
          else openCount
        loop(tail,nextOpen)
    loop(chars,0)
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    //base cases
    if money < 0 || coins.isEmpty then 0
    else if money == 0 then 1
    else
    //recursive cases
      countChange(money - coins.head ,coins) +
      countChange(money, coins.tail)
