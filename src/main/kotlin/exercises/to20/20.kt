package exercises.to20

import java.math.BigInteger
import kotlin.system.exitProcess

fun main() {
    println(factory(100).let{ sumOfDigits(it) })
    exitProcess(0)
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