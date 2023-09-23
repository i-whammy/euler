package exercises.to20

// https://projecteuler.net/problem=5

import functions.isPrime
import java.math.BigDecimal
import kotlin.system.exitProcess

fun main() {
    println(smallestMultipleUntil(20))
    exitProcess(0)
}

fun smallestMultipleUntil(number: Int): BigDecimal {
    val primes = mutableListOf<Int>()
    (1..number).filter { isPrime(it.toLong()) }.forEach { primes.add(it) }
    return primes.map { getMaxMultipleUntil(it, number) }.reduce { acc, i -> acc * i }.toBigDecimal()
}

fun getMaxMultipleUntil(number: Int, limit: Int): Int {
    var result = 1
    while (true) {
        val temporaryResult = result * number
        if (temporaryResult > limit) break
        result = temporaryResult
    }
    return result
}