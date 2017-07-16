package me.dbolshak.chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 19/05/2017.
  */
class TupleSpec extends FlatSpec with Matchers {
  "simple example of tuples" should "work with different types at the same time" in {
    val pair = (99, "Luftballons")
    pair._1 should be (99)
    pair._2 should be ("Luftballons")
  }

  "actual types of tuple" should "depend on tuple size and type of its items" in {
    (99, "Luftballons") match  { case t: Tuple2[Int, String] => println("got it")}
  }
}
