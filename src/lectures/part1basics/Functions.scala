package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects (aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  // 1. gretting function
  def greet(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old."
  println(greet("Memo", 26))

  // Factorial
  def factorial(n: Int): Int =
    if (n <= 0) n
    else n * factorial(n - 1)
  println(factorial(4))

  // Fibonacci
  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  println(fibonacci(18))

  def prime(n: Int): Boolean = {
    def f(rn: Int, acc: Int): Boolean = {
      if (rn == acc) {
        true
      } else if (rn % acc == 0) {
        false
      } else f(rn, acc + 1)
    }

    f(n, 2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37*17))
}
