import java.util.StringTokenizer

/**
 *
 * @author Vladislav Isenbaev (vladislav.isenbaev@odnoklassniki.ru)
 */

object CFTemplateBak extends App {
  val tokenizer = new StringTokenizer(_: String)

  var st: StringTokenizer = tokenizer("")

  class FromString[A](val f: String => A)

  implicit val string2int = new FromString(_.toInt)
  implicit val string2long = new FromString(_.toLong)
  implicit val string2double = new FromString(_.toDouble)
  implicit val string2bigInt = new FromString(BigInt(_))

  def nextToken(): String = {
    while (!st.hasMoreTokens) {
      val line = Console.readLine()
      if (line == null) return null
      st = tokenizer(line)
    }
    st.nextToken()
  }

  def next[A]()(implicit converter: FromString[A]): A = converter.f(nextToken())

  def nextSeq[A](len: Int = next[Int]())(implicit c: FromString[A]): Seq[A] = for (i <- 0 until len) yield next[A]()

  val n = next[Int]()
  val k = next[Int]()

  val pairs = for (i <- 0 until n) yield (next[Int](), next[Int]())

}