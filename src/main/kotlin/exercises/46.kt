package exercises

import functions.isPrime
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    println(composites(10000).filter { it % 2 == 1 && !isPrime(it.toBigInteger()) }.filter { !isGoldbach(it) })
    kotlin.system.exitProcess(0)
}

fun composites(below: Int): List<Int> {
    return (1..below).filter { !isPrime(it.toBigInteger()) && it % 2 == 1 }
}

fun isGoldbach(n: Int): Boolean {
    if (n == 1) return false
    val primes = (1..n).filter { isPrime(it.toBigInteger()) }
    return primes.any { isTwiceSquare(n - it) }
}

fun isTwiceSquare(n: Int): Boolean {
    val base = sqrt((n / 2).toDouble()).toInt()
    return (1..base).any { n == it.toDouble().pow(2).toInt() * 2 }
}