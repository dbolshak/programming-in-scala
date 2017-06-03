package me.dbolshak.chapter01

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dbolshak on 19/05/2017.
  */
class CountriesMapSpec extends FlatSpec with Matchers {

  "gets the capital associated with the country France" should "return Paris" in {
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital("France") should be ("Paris")
  }

  "gets the capital associated with the country Japan" should "return Tokyo" in {
    var capital = Map("US" -> "Washington", "France" -> "Paris")

    capital += ("Japan" -> "Tokyo")
    capital("Japan") should be ("Tokyo")
  }
}
