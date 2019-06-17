package jzjx

import com.softwaremill.sttp.HttpURLConnectionBackend

abstract class JZJXHttpRequest {
  val URL = "https://www.ccdriving.ca/index.php"
  implicit val backend = HttpURLConnectionBackend()
  val parameters: Map[String, String]
}

//object JZJXHttpRequest {
//
//}
