package jzjx

import com.softwaremill.sttp._
import org.apache.commons.lang.StringEscapeUtils

object Main {
  def main(args: Array[String]): Unit = {

    implicit val backend = HttpURLConnectionBackend()

    val parametersTestResult = Map("route" -> "test/mock/submit",
      "test_type" -> "view",
      "test_result" -> "1",
      "question_id" -> "84"
    )

    val submitTestResult = sttp.get(uri"https://www.ccdriving.ca/index.php?$parametersTestResult")
      .cookie("PHPSESSID", "e49a9b61cc9d9f6965a2b28d9189b66e")

    val response = submitTestResult.send()

    println(response.body)

    val parametersNext = Map("route" -> "test/mock/next",
      "test_type" -> "view")

    val requestNewQuestion = sttp.get(uri"https://www.ccdriving.ca/index.php?$parametersNext")
      .cookie("PHPSESSID", "e49a9b61cc9d9f6965a2b28d9189b66e")

    val responseNext = requestNewQuestion.send()

    val content = responseNext.body.getOrElse("")

    println(StringEscapeUtils.unescapeJava(content))

  }
}
