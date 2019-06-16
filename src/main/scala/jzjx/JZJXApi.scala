package jzjx

import com.softwaremill.sttp.{HttpURLConnectionBackend, SttpBackend}

abstract class JZJXApi {
  val URL = "https://www.ccdriving.ca/index.php"

  implicit val backend = HttpURLConnectionBackend()

  val parameters: Map[String, String]

}
