package exercises.to20

// https://projecteuler.net/problem=7

import functions.isPrime
import kotlin.system.exitProcess

fun main() {
    println(findNthPrime(10001))
    exitProcess(0)
}

fun findNthPrime(n: Int): Long {
    val primes = mutableListOf<Long>()
    var target = 2L
    while (primes.size < n) {
        if (isPrime(target)) primes.add(target)
        target++
    }
    return primes.last()
}