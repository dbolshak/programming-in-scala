package me.dbolshak.chapter02

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 19/05/2017.
  */
class FunctionDefiningSpec extends FlatSpec with Matchers {

  def max(x: Int, y: Int) = if (x > y) x else y

  "just defined max function" should "2 if inputs are 1 and 2" in {
    max(1, 2) should be (2)
  }
}
