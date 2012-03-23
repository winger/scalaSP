import collection.mutable.Stack

/**
 *
 * @author Vladislav Isenbaev (vladislav.isenbaev@odnoklassniki.ru)
 */

val mod = 50515093
val n = 2000000000

val stack = Stack((-1L, 0))
var curSum = 0L
var ans = 0L

val seq = Iterator.iterate(290797L)(x => x * x % mod).take(n + 1).zipWithIndex

for ((x, i) <- seq if i > 0) {
  while (stack.head._1 >= x) {
    val (v, pos) = stack.pop()
    val (_, prevPos) = stack.head
    curSum -= v * (pos - prevPos)
  }
  val (_, lastPos) = stack.head
  curSum += x * (i - lastPos)
  stack.push((x, i))
  
  ans += curSum
  
  if (i % 1000000 == 0) {
    println(i + " " + x + " " + ans)
    Console.flush()
  }
}

println(ans)