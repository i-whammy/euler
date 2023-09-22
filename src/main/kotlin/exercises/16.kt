package exercises

import java.math.BigInteger

// https://projecteuler.net/problem=16

fun main() {
    println(powerDigitSum(15))
    println(powerDigitSum(1000))
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