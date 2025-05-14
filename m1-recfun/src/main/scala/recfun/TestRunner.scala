package recfun

import RecFun._

object TestRunner extends App:
  println(pascal(1, 3)) // 3
  println(pascal(0, 0)) // 1
  println(pascal(0, 2)) // 1
  println(pascal(1, 2)) // 2
  println(pascal(1, 3)) // 3
  println(pascal(2, 4)) // 6
  println("\nBalance Tests:")
  
  // ✅ Balanced cases
  println(balance("".toList))                          // true — empty string
  println(balance("()".toList))                        // true
  println(balance("(if (a < b) (b - a) else (a - b))".toList)) // true
  println(balance("I told him (that it's (not yet) done).".toList)) // true
  println(balance("(()())".toList))                    // true
  println(balance("(a + (b + c) + (d))".toList))       // true
  
  // ❌ Unbalanced: too many closing
  println(balance("())(".toList))                      // false
  println(balance("())".toList))                       // false
  println(balance(")(" .toList))                       // false
  
  // ❌ Unbalanced: too many opening
  println(balance("(((".toList))                       // false
  println(balance("(()".toList))                       // false
  
  // ❌ No actual parentheses, but unbalanced emoticon
  println(balance(":-)".toList))                       // false
  println(balance("())(()".toList))                    // false
  
  // ✅ Complex balanced
  println(balance("function(arg1, (arg2), (arg3 + arg4))".toList)) // true
  
  // Edge case: multiple other symbols
  println(balance("let x = ((3 * 5) + 2) in x".toList))           // true
  println(balance("let x = ((3 * 5) + 2 in x".toList))            // false
