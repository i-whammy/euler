package functions

import java.math.BigInteger
import kotlin.math.sqrt

fun isPrime(target: BigInteger): Boolean {
    if (target == BigInteger.TWO) return true
    if (target == BigInteger.ONE) return false
    else {
        var dividend = BigInteger.TWO
        val limit = sqrt(target.toDouble()).toLong().toBigInteger()
        while (dividend <= limit) {
            if (target % dividend == BigInteger.ZERO) return false
            dividend += BigInteger.ONE
        }
    }
    return true
}