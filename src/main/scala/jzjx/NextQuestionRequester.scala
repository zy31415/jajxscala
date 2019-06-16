package jzjx

import org.apache.commons.lang.StringEscapeUtils
import com.softwaremill.sttp.sttp
import com.softwaremill.sttp.UriContext
import org.json.JSONObject


class NextQuestionRequester (val phpsessid: String) extends JZJXApi {

  override val parameters = Map("route" -> "test/mock/next", "test_type" -> "view")

  def send(): (Question, Summary) = {
    val submitTestResult = sttp.get(uri"$URL?$parameters")
      .cookie("PHPSESSID", phpsessid)
    val response = submitTestResult.send()
    val content = response.body.getOrElse("")

    val result = StringEscapeUtils.unescapeJava(content)

    val obj = new JSONObject(result)
    val test_question = obj.getJSONObject("question")
    val summary = obj.getJSONObject("summary")

    (new Question(test_question), new Summary(summary))
  }

}
