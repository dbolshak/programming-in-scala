package me.dbolshak.chapter05

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 19/05/2017.
  */
class LiteralsSpec extends FlatSpec with Matchers {
  "integer literals" should "support hexadecimal" in {
    0x5 should be(5)
    0x00FF should be(255)
    0xcafebabe should be(-889275714)
  }

  "integer literals" should "support decimal" in {
    31 should be(31)
    255 should be(255)
    20 should be(20)
  }

  "literals for Long" should "be ended by `l` or `L`" in {
    1L match {
      case longType: Long => "ok"
    }
    2l match {
      case longType: Long => "ok"
    }
  }

  "long literals for" should "support hexadecimal and ended by `L`" in {
    0XCAFEBABEL should be(3405691582L)
  }

  "assigning a integer literal to variable of Short type" should "work as the literal value is within the valid range for that type" in {
    val little: Short = 367
    little match {
      case short: Short => short should be(367)
    }
  }
}
