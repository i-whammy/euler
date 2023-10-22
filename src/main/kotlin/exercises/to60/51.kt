package exercises.to60

import functions.isPrime
import kotlin.math.max

private const val UPPER_LIMIT = 1_000_000
private val primes = (2..UPPER_LIMIT).filter { isPrime(it.toBigInteger()) }

fun main() {
    println(primes.firstOrNull { countPossiblePrimes(it) == 8 })
    kotlin.system.exitProcess(0)
}

fun countPossiblePrimes(prime: Int): Int {
    val primeStr = prime.toString()
    val firstDigit = primeStr[0].toString()
    val firstDigitCount = (1..9).map {
        primeStr.replace(firstDigit, it.toString())
    }.count { primes.contains(it.toInt()) }
    val remainingCount = (0..9)
        .filter {
            it != firstDigit.toInt()
                    && primeStr.contains(it.toString())
        }
        .map { a ->
            (0..9)
                .map { b -> primeStr.replace(a.toString(), b.toString()) }
                .filter { primes.contains(it.toInt()) }
        }.maxByOrNull { it.size }?.size ?: 0
    return max(firstDigitCount, remainingCount)
}