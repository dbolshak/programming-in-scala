package me.dbolshak.chapter06

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 19/05/2017.
  */
class RationalSpec extends FlatSpec with Matchers {

  behavior of "Rational constructor"
  it should "be possible to create Rational object with non zero denominator" in {
    new Rational(1, 2)
  }
  it should "produce IllegalAccessException when zero passed as denominator" in {
    assertThrows[IllegalArgumentException] {
      new Rational(1, 0)
    }
  }
  it should "create 5/1 while calling auxiliary constructor passing only numerator" in {
    new Rational(5).toString should be ("5/1")
  }

  behavior of "Rational accessors"
  it should "return first parameter of Constructor by numer method" in {
    val n = 1
    new Rational(n, 2).numer should be (n)
  }
  it should "return second parameter of Constructor by denom method" in {
    val d = 2
    new Rational(1, d).denom should be (d)
  }

  "toString method" should "return nice to see String" in {
    new Rational(12, 2347).toString should be ("12/2347")
  }

  "1/2 + 2/3" should "return 7/6" in {
    (new Rational(1, 2) + new Rational(2, 3)).toString should be ("7/6")
  }

  "1/2" should "be less than 2/3" in {
    new Rational(1, 2)  < new Rational(2, 3) should be (true)
  }

  "max on 1/2 and 2/3" should "be 2/3" in {
    val small = new Rational(1, 2)
    val big = new Rational(2, 3)
    small.max(big) should be (big)
  }

  "66/42" should "yield 11/7" in {
    new Rational(66, 42).toString should be ("11/7")
  }

  "1/2 * 2/3" should "yield 1/3" in {
    (new Rational(1, 2) * new Rational(2, 3)).toString should be ("1/3")
  }

  "1/2 + 1/2 * 2/3" should "yield 5/6" in {
    val x = new Rational(1, 2)
    val y = new Rational(2, 3)

    (x + x * y).toString should be ("5/6")
  }

  "ariphmetic operations on mixed types" should "be also possible" in {
    (new Rational(1, 2) + 1).toString should be ("3/2")
    (new Rational(1, 2) * 2).toString should be ("1/1")
  }

  "example from book" should "work fine" in {
    val x = new Rational(2, 3)
    x.toString should be ("2/3")

    (x * x).toString should be ("4/9")

    (x * 2).toString should be ("4/3")
  }

  "conversion method from Int to Rational" should "work using implicits" in {
    import Rational.intToRational

    val r = new Rational(2,3)

    (2 * r).toString should be ("4/3")
  }

  behavior of "gcd helper method of Companion object"
  it should "return 4 for 12 and 8 (and vice versa)" in {
    Rational.gcd(12, 8) should be (4)
    Rational.gcd(8, 12) should be (4)
  }
  it should "return 1 if there is no common devisor" in {
    Rational.gcd(11, 17) should be (1)
  }
}
