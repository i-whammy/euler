package functions

import kotlin.math.sqrt

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