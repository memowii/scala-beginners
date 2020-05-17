package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }
  // println(anotherFactorial(5000))
  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
    = 1 * 2 * 3 * 4 * ... * 10
   */

  // WHEN YOU NEED LOOPS USE _TAIL_RECURSION

  def concatenate(aString: String, n: Int): String = {
    @tailrec
    def helper(x: Int, acc: String): String = {
      if (x <= 0) acc
      else helper(x - 1, acc + aString)
    }

    helper(n, "")
  }

  @tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailRec(aString, n-1, aString + accumulator)

  println(concatenate("Memo", 4))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def helper(t: Int, acc: Boolean): Boolean =
      if (t <= 1) acc
      else helper(t - 1, n % t != 0 && acc)

    helper(n / 2, true)
  }

  def isPrimeC(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(12983))

  def fibonacci(n: Int): Int = {
    @tailrec
    def helper(t: Int, acc1: Int, acc2: Int, acc3: Int): Int =
      if (t <= 2) 1
      else helper(t - 1, acc1, acc2, acc3)

    helper(n, 1, 1, 1 + 1)
  }

  println(fibonacci(1))
  println(fibonacci(2))
  println(fibonacci(3))

  def fibonacci2(n: Int): Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci2(8)) // 1 1 2 3 5 8 13, 21
}
