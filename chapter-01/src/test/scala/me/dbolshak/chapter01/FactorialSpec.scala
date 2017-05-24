package me.dbolshak.chapter01

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 19/05/2017.
  */
class FactorialSpec extends FlatSpec with Matchers {

  def factorial(x: BigInt): BigInt = if (x == 0) 1 else x * factorial(x - 1)

  "factorial(30)" should "return 265252859812191058636308480000000" in {
    factorial(30) should be (BigInt("265252859812191058636308480000000"))
  }
}
