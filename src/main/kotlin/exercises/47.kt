package exercises

import functions.isPrime

private val primes = (1..150000L).filter { isPrime(it.toBigInteger()) }

// As the answer is 4 distinct primes factor, the answer <= 2 * 3 * 5 * 7 = 210
fun main() {
    val answers = (1..150000L)
        .filter { getFactors(it).distinctPrimeFactors() == 4 }
    println(findConsecutiveCounts(answers).first { it.second == 4 })
    kotlin.system.exitProcess(0)
}

fun primesBelow(n: Long): List<Long> {
    return primes.filter { n % it == 0L }
}

fun getFactors(n: Long): List<Pair<Long, Long>> {
    val primesBelow = primesBelow(n)
    val result = mutableListOf<Pair<Long, Long>>()
    primesBelow.forEach { prime ->
        var number = n
        var count = 0L
        while (number % prime == 0L) {
            number /= prime
            count++
        }
        if (count > 0L) {
            result.add(prime to count)
        }
    }
    return result
}

fun List<Pair<Long, Long>>.distinctPrimeFactors() = this.size

fun findConsecutiveCounts(numbers: List<Long>): List<Pair<Long, Int>> {
    return numbers.map { l ->
        var count = 1
        var num = l
        while (numbers.contains(num + 1)) {
            count++
            num++
        }
        l to count
    }
}