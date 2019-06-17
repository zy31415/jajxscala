package jzjx

import com.softwaremill.sttp.{UriContext, sttp}

class UpdateTestResultRequest(val phpsessid: String) extends JZJXHttpRequest {

  override val parameters = Map(
    "route" -> "test/mock/submit",
    "test_type" -> "view",
    "test_result" -> "1"
  )

  def send(answer: Answer): String = {
    val par = parameters + ("question_id" -> s"${answer.questionId}")
    val submitTestResult = sttp.get(uri"$URL?$par")
      .cookie("PHPSESSID", phpsessid)
    val response = submitTestResult.send()
    response.body.getOrElse("")
  }

}
