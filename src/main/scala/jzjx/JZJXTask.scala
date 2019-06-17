package jzjx

class JZJXTask (val phpsessid: String) {
  def cons(): (NextQuestionRequest, UpdateTestResultRequest) = {
    (new NextQuestionRequest(phpsessid), new UpdateTestResultRequest(phpsessid))
  }
}
