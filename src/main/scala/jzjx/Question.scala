package jzjx

import org.json.JSONObject

class Question (val json: String){
  val obj = new JSONObject(json)
  val test_question_id = obj.getJSONObject("question").get("test_question_id")
  val question = obj.getJSONObject("question").get("question")
  val answer = obj.getJSONObject("question").get("answer")
}
