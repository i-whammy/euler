// https://projecteuler.net/problem=3

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

fun isPrime(target: Long): Boolean {
    if (target == 2L) return true
    else {
        var dividend = 2L
        val limit = sqrt(target.toDouble()).toLong()
        while (dividend <= limit) {
            if (target % dividend == 0L) return false
            dividend += 1
        }
    }
    return true
}
