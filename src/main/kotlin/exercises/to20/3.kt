package exercises.to20

// https://projecteuler.net/problem=3

import functions.isPrime
import kotlin.math.sqrt
import kotlin.system.exitProcess

fun main() {
    println(largestPrimeFactor(600_851_475_143L))
    exitProcess(0)
}

fun largestPrimeFactor(target: Long): Long {
    var dividend = sqrt(target.toDouble()).toLong()
    while (true) {
        if (target % dividend == 0L && isPrime(dividend)) return dividend
        dividend -= 1
        println("$dividend is not prime")
    }
}

