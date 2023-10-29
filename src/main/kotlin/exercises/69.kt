package exercises

import functions.isPrime
import kotlin.math.sqrt

private const val limit = 1_000_000
private val primes = (1..limit).filter { isPrime(it.toBigInteger()) }

fun main() {
    var max = MaxNAndFraction(0, 0.0)
    (2..limit).forEach { number ->
        if (primes.contains(number)) {
//            max = max.confirm(number, number - 1) // perhaps this is not necessary as primes cannot be the answer
            return@forEach
        }
        val sqrt = sqrt(number.toDouble()).toInt()
        val targets = if (number % 2 == 0) (1..sqrt).filter { it % 2 == 1 } else (1..sqrt)
        val count = targets.count { areRelativePrime(it, number) }
        max = max.confirm(number, count)
    }
    println(max)
    kotlin.system.exitProcess(0)
}

fun areRelativePrime(a: Int, b: Int): Boolean {
    return getGCM(a, b) == 1
}

// GCM stands for greatest common divisor
fun getGCM(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (x % y != 0) {
        val tmpX = x
        x = y
        y = tmpX % y
    }
    return y
}

data class MaxNAndFraction(val n: Int, val fraction: Double) {
    fun confirm(n: Int, count: Int): MaxNAndFraction {
        val fraction = n.toDouble() / count
        return if (fraction > this.fraction) {
            MaxNAndFraction(n, fraction)
        } else this
    }
}