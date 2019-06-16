package jzjx

import org.apache.commons.lang.StringEscapeUtils
import com.softwaremill.sttp.sttp
import com.softwaremill.sttp.UriContext


class NextQuestionRequester (val phpsessid: String) extends JZJXApi {

  override val parameters = Map("route" -> "test/mock/next", "test_type" -> "view")

  def send(): Question = {
    val submitTestResult = sttp.get(uri"$URL?$parameters")
      .cookie("PHPSESSID", phpsessid)
    val response = submitTestResult.send()
    val content = response.body.getOrElse("")

    new Question(StringEscapeUtils.unescapeJava(content))
  }

}
