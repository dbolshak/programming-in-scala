package me.dbolshak.chapter05

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 19/05/2017.
  */
class LiteralsSpec extends FlatSpec with Matchers {
  "integer literals" should "support hexadecimal" in {
    0x5 should be (5)
    0x00FF should be (255)
    0xcafebabe should be (-889275714)
  }
}
