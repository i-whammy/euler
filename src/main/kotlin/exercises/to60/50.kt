package exercises.to60

import functions.isPrime
import kotlin.math.max
import kotlin.math.min

fun main() {
    val limit = 1_000_000
    var maximumSum = 0
    val primality = (1..limit).map { it to isPrime(it.toBigInteger()) }
    val primes = primality.filter { it.second }.map { it.first }
    var max = 0
    primes.forEachIndexed { i, prime ->
        var sum = prime
        var count = 1
        (i + 1..<primes.size).forEach { j ->
            sum = min(sum + primes[j], limit)
            count += 1
            if (sum < limit && primality[sum-1].second && max < count) {
                max = max(max, count)
                maximumSum = max(maximumSum, sum)
            }
        }
    }
    println(max)
    println(maximumSum)
    kotlin.system.exitProcess(0)
}