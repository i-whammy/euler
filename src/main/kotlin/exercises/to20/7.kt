package exercises.to20

// https://projecteuler.net/problem=7

import functions.isPrime
import java.math.BigInteger
import kotlin.system.exitProcess

fun main() {
    println(findNthPrime(10001))
    exitProcess(0)
}

fun findNthPrime(n: Int): BigInteger {
    val primes = mutableListOf<BigInteger>()
    var target = BigInteger.TWO
    while (primes.size < n) {
        if (isPrime(target)) primes.add(target)
        target++
    }
    return primes.last()
}