package example

object Lists:

  /**
   * This method computes the sum of all elements in the list xs. There are
   * multiple techniques that can be used for implementing this method, and
   * you will learn during the class.
   *
   * For this example assignment you can use the following methods in class
   * `List`:
   *
   *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
   *  - `xs.head: Int` returns the head element of the list `xs`. If the list
   *    is empty an exception is thrown
   *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the
   *    list `xs` without its `head` element
   *
   *  ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
   *  solution.
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
  def sum(xs: List[Int]): Int = {
    /**
     * Tail recursive helper function to accumulate the sum
     * @param remaining The remaining elements of the list to evaluate
     * @param accSum The total accumulated sum so far
     * @return The sum of all the elements in the list
     */
    @annotation.tailrec
    def loop(remaining: List[Int], accSum: Int ): Int = {
      // Base case: Return the accumulated sum when the list is empty
      if (remaining.isEmpty) { accSum }
      // Recursive case: Add the first item of the list to the accumulated sum
      // and then run the function on the list with the first item removed
      else {
        loop(remaining.tail, accSum + remaining.head)
      }
    }
    // Start the recursion with an initial value of zero for the accumulated sum
    loop(xs,0)
  }

  /**
   * This method returns the largest element in a list of integers. If the
   * list `xs` is empty it throws a `java.util.NoSuchElementException`.
   *
   * You can use the same methods of the class `List` as mentioned above.
   *
   * ''Hint:'' Again, think of a recursive solution instead of using looping
   * constructs. You might need to define an auxiliary method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  def max(xs: List[Int]): Int = {
    /**
     * A Tail recursive helper to find the largest item in a list
     * @param remaining The remaining items in the list to evaluate
     * @param currentMax The largest value found so far
     * @return The largest value in the list
     */
    @annotation.tailrec
    def loop(remaining: List[Int], currentMax: Int): Int = {
      // Base Case: Found the largest value when the list is empty
      if (remaining.isEmpty) {currentMax}
      // Recursive Case: Compare the head to the current max, return the tail of the list
      else {loop(remaining.tail, if(remaining.head > currentMax) {remaining.head} else currentMax)}
    }
    if (xs.isEmpty) {throw new NoSuchElementException("Can't have a max of empty list")}
    // Start the recursion with the first element as the initial max
    else {loop(xs.tail,xs.head)}
  }
