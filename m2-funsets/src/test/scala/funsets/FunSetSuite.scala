
package funsets

/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  trait TestSets:
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s12 = union(s1, s2)
    val s123 = union(s12, s3)

  test("singleton set one contains one") {
    new TestSets:
      assert(contains(s1, 1), "Singleton")
  }

  test("union contains all elements of each set") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
  }

  test("intersect contains only common elements") {
    new TestSets:
      val s = intersect(s12, s2)
      assert(contains(s, 2), "Intersect 2")
      assert(!contains(s, 1), "Intersect 1")
  }

  test("diff contains elements in first but not in second") {
    new TestSets:
      val s = diff(s12, s2)
      assert(contains(s, 1), "Diff 1")
      assert(!contains(s, 2), "Diff 2")
  }

  test("filter selects only elements matching predicate") {
    new TestSets:
      val s = filter(s123, x => x % 2 == 1)
      assert(contains(s, 1), "Filter 1")
      assert(contains(s, 3), "Filter 3")
      assert(!contains(s, 2), "Filter 2")
  }

  test("forall returns true if all elements match predicate") {
    new TestSets:
      assert(forall(s123, x => x > 0), "All elements > 0")
      assert(!forall(s123, x => x % 2 == 0), "Not all even")
  }

  test("exists returns true if any element matches predicate") {
    new TestSets:
      assert(exists(s123, x => x == 2), "Exists 2")
      assert(!exists(s123, x => x == 4), "Does not exist 4")
  }

  test("map transforms a set correctly") {
    new TestSets:
      val mapped = map(s123, x => x * 2)
      assert(contains(mapped, 2), "Mapped 1 * 2")
      assert(contains(mapped, 4), "Mapped 2 * 2")
      assert(contains(mapped, 6), "Mapped 3 * 2")
      assert(!contains(mapped, 1), "Should not contain 1")
  }

  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
