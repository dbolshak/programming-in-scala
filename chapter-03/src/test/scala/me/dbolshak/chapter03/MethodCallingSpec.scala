package me.dbolshak.chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 19/05/2017.
  */
class MethodCallingSpec extends FlatSpec with Matchers {
  "0 to 2" should "be the same as 0.to(2)" in {
    0 to 2 should be (0.to(2))
  }

  "0 to 2" should "be ended by 2" in {
    (0 to 2).reverse.head should be (2)
  }

  "1 + 2" should "be the same as 1.+(2)" in {
    0 + 2 should be (0.+(2))
  }
}
