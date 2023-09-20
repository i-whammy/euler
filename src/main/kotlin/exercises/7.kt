package exercises

// https://projecteuler.net/problem=7

import functions.isPrime

fun main() {
    println(findNthPrime(10001))
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