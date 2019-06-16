package jzjx

class JZJXTask (val phpsessid: String) {
  def cons(): (NextQuestionRequester, TestResultSubmitter) = {
    (new NextQuestionRequester(phpsessid), new TestResultSubmitter(phpsessid))
  }
}
