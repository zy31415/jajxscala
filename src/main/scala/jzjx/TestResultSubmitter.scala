package jzjx

import com.softwaremill.sttp.sttp
import com.softwaremill.sttp.UriContext
import org.apache.commons.lang.StringEscapeUtils

class TestResultSubmitter (val phpsessid: String) extends JZJXApi {

  override val parameters = Map(
    "route" -> "test/mock/submit",
    "test_type" -> "view",
    "test_result" -> "1"
  )

  def send(answer: Answer): Unit = {
    val par = parameters + ("question_id" -> s"${answer.questionId}")
    val submitTestResult = sttp.get(uri"$URL?$par")
      .cookie("PHPSESSID", phpsessid)

    val response = submitTestResult.send()

    val content = response.body.getOrElse("")

    println(StringEscapeUtils.unescapeJava(content))
  }

}
