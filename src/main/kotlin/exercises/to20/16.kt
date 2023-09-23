package exercises.to20

import java.math.BigInteger
import kotlin.system.exitProcess

// https://projecteuler.net/problem=16

fun main() {
    println(powerDigitSum(15))
    println(powerDigitSum(1000))
    exitProcess(0)
}

fun powerDigitSum(exponent: Int): Int {
    val pow = 2.pow(exponent)
    return pow.toString().toCharArray().map { it.toString().toInt() }.reduce { acc, i -> acc + i }
}

fun Int.pow(exponent: Int): BigInteger {
    var base = BigInteger.ONE
    var count = 0
    while (count < exponent) {
        base *= this.toBigInteger()
        count++
    }
    return base
}