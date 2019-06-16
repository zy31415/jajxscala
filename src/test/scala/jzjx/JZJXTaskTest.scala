package jzjx

import org.scalatest.FunSuite

class JZJXTaskTest extends FunSuite {
  test("submit result") {
    val task = new JZJXTask("e49a9b61cc9d9f6965a2b28d9189b66e")
    val (requester, submitter) = task.cons()

    val answer = new Answer(100)
    submitter.send(answer)
  }

  test("request next") {
    val task = new JZJXTask("e49a9b61cc9d9f6965a2b28d9189b66e")
    val (requester, submitter) = task.cons()
    val (question, summary) = requester.send()
    println(question.json)
  }
}
