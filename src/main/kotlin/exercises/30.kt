package exercises

//https://projecteuler.net/problem=30

import kotlin.math.pow

fun main() {
    println((1..999999).filter { it == sumOfNthPowerOfDigits(it, 5) }.sum())
    kotlin.system.exitProcess(0)
}

fun sumOfNthPowerOfDigits(value: Int, n: Int): Int {
    return value.toString()
        .map { it.digitToInt().toDouble().pow(n) }
        .sum().toInt()
}