package me.dbolshak.chapter02

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 01/06/2017.
  */
class LoopSpec extends FlatSpec with Matchers {
  val args = Array("Hello", ", ", "world", "!")

  "every item in Array" should "be printed in while loop" in {
    var i = 0
    while (i < args.length) {
      print(args(i))
      i += 1
    }
    i should be (args.length)
  }

  it should "be printed using foreach" in {
    var i = 0
    args.foreach { arg =>
        print(arg)
        i += 1
    }
    i should be (args.length)
  }


  it should "be printed using for expression" in {
    var i = 0
    for (arg <- args) {
        print(arg)
        i += 1
    }
    i should be (args.length)
  }
}
