package jzjx

import org.json.JSONObject

class Question (val json: JSONObject){
  val test_question_id = json.get("test_question_id")
  val question = json.get("question")
  val answer = json.get("answer")
}
