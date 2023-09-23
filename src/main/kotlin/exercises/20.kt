package exercises

import java.math.BigInteger

fun main() {
    println(factory(100).let{ sumOfDigits(it) })
}

fun factory(below: Int): BigInteger {
    return when (below) {
        1 -> BigInteger.ONE
        else -> BigInteger.valueOf(below.toLong()) * factory(below - 1)
    }
}

fun sumOfDigits(number: BigInteger): Int {
    return number.toString().map { it.toString().toInt() }.reduce { acc, i -> acc + i }
}