package me.dbolshak.chapter06

class Rational(n: Int, d: Int) {
  require(d != 0, s"Failed to call Rational($n, $d), because d could not be zero")

  private val g = Rational.gcd(n.abs, d.abs)
  val numer: Int = n/g
  val denom: Int = d/g

  def this(n: Int) = this(n, 1)

  override def toString: String = s"${numer}/${denom}"

  def + (that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def + (i: Int): Rational = new Rational(numer + i * denom, denom)

  def < (that: Rational): Boolean = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def * (that: Rational): Rational = new Rational(numer * that.numer, denom * that.denom)
  def * (i: Int): Rational = new Rational(numer * i, denom)

  def - (that: Rational): Rational = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def - (i: Int): Rational = new Rational(numer - i * denom, denom)

  def / (that: Rational): Rational = new Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational = new Rational(numer, denom * i)
}

object Rational {
  implicit def intToRational(x: Int) = new Rational(x)

  def gcd(n: Int, d: Int): Int = if (d == 0) n else gcd(d, n % d)
}
