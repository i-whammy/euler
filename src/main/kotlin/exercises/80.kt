package exercises

import java.math.BigInteger
import kotlin.math.sqrt

private const val UPPER_LIMIT = 100
private val nonSquareRoots = (1..UPPER_LIMIT).filterNot { n ->
    (1..sqrt(UPPER_LIMIT.toDouble()).toInt()).map { it * it }.contains(n)
}

fun main() {
    val sum = nonSquareRoots.fold(0) { acc, i -> acc + sumUpSqrtDigits(i) }
    println(sum)
    kotlin.system.exitProcess(0)
}

fun sumUpSqrtDigits(n: Int): Int {
    var target = n.toString()
    var current = sqrt(target.toDouble()).toInt().toString()
    while (current.length < 100) {
        target += "00"
        inner@ for (s in 0..9) {
            val tmp = current + s.toString()
            if (target.toBigInteger() < tmp.toBigInteger().plus(BigInteger.ONE).pow(2)) {
                current += s.toString()
                break@inner
            }
        }
    }
    return current.map { it.digitToInt() }.sum()
}