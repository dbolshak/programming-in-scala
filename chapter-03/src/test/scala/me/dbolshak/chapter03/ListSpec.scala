package me.dbolshak.chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 19/05/2017.
  */
class ListSpec extends FlatSpec with Matchers {
  "building List using factory pattern" should "produce scala.List which is immutable" in {
    List("orange", "apple", "banana") match {
      case fruits: List[String] => println("works as expected")
    }

    List("orange", "apple", "banana") match {
      case fruits: scala.List[String] => println("works as expected")
    }

    List("orange", "apple", "banana") match {
      case fruits: scala.collection.immutable.List[String] => println("works as expected")
    }
  }

  "concatenation of immutable lists" should "produce new instance of List" in {
    val l1 = List(1, 2, 3)
    val l2 = List(4, 5, 6)

    (l1:::l2) should have size(6)

    l1 should be (List(1, 2, 3))
    l2 should be (List(4, 5, 6))
  }

  "cons example" should "prepend item" in {
    val twoThree = List(2, 3)
    val oneTwoThree = 1::twoThree

    oneTwoThree should be (List(1, 2, 3))
  }

  "cons example (using explicit signature)" should "prepend item" in {
    val twoThree = List(2, 3)
    val oneTwoThree = twoThree.::(1)

    oneTwoThree should be (List(1, 2, 3))
  }

  "one way to initialize new lists is to string together elements with the cons operator" should "be possible usint Nil" in {
    val oneTwoThree = 1 :: 2 :: 3 :: Nil

    oneTwoThree should be (List(1, 2, 3))
  }

  "list operations" should "work" in {
    val oneTwoThree = 1 :: 2 :: 3 :: Nil

    //Returns the element at index 0 (zero based) of the oneTwoThree list
    oneTwoThree(0) should be (1)

    //Counts the number of elements in oneTwoThree that less then 2
    oneTwoThree.count(_ < 2) should be(1)

    //Returns the oneTwoThree list without its first 2 elements (returns List(3))
    oneTwoThree.drop(2) should be(List(3))

    //Returns the oneTwoThree list without its rightmost 2 elements (returns List(1))
    oneTwoThree.dropRight(2) should be(List(1))

    //Determines whether a number element exists in oneTwoThree that has the value 2 (returns true)
    oneTwoThree.exists(_ == 2) should be (true)

    //Returns a list of non even values (returns List(1, 3))
    oneTwoThree.filter(_ % 2 != 0) should be (List(1, 3))

    //Indicates whether all elements in the oneTwoThree larger 0 or large 2
    oneTwoThree.forall(_ > 0) should be (true)
    oneTwoThree.forall(_ > 2) should be (false)

    //Executes the print statement on each of the item in the oneTwoThree list
    oneTwoThree.foreach(print)

    //Returns the first element in the thrill list (returns 1)
    oneTwoThree.head should be (1)

    //Returns a list of all but the last element in the oneTwoThree list (returns List(1, 2))
    oneTwoThree.init should be (List(1,2))

    //Indicates whether the oneTwoThree list is empty (returns false)
    oneTwoThree.isEmpty should be (false)

    //Returns the last element in the oneTwoThree list (returns 3)
    oneTwoThree.last should be (3)
  }
}
