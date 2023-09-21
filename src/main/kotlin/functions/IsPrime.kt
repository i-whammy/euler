package functions

import kotlin.math.sqrt

fun isPrime(target: Long): Boolean {
    if (target == 2L) return true
    if (target == 1L) return false
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