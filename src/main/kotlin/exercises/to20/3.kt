package exercises.to20

// https://projecteuler.net/problem=3

import functions.isPrime
import java.math.BigInteger
import kotlin.math.sqrt
import kotlin.system.exitProcess

fun main() {
    println(largestPrimeFactor(BigInteger.valueOf(600_851_475_143L)))
    exitProcess(0)
}

fun largestPrimeFactor(target: BigInteger): BigInteger {
    var dividend = sqrt(target.toDouble()).toLong().toBigInteger()
    while (true) {
        if (target % dividend == BigInteger.ZERO && isPrime(dividend)) return dividend
        dividend -= BigInteger.ONE
        println("$dividend is not prime")
    }
}

