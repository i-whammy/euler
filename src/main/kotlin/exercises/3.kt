package exercises

// https://projecteuler.net/problem=3

import functions.isPrime
import kotlin.math.sqrt

fun main() {
    println(largestPrimeFactor(600_851_475_143L))
}

fun largestPrimeFactor(target: Long): Long {
    var dividend = sqrt(target.toDouble()).toLong()
    while (true) {
        if (target % dividend == 0L && isPrime(dividend)) return dividend
        dividend -= 1
        println("$dividend is not prime")
    }
}

