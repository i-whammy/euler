package exercises.to60

import functions.isPrime

private const val upperLimit = 1_000_000L
private val primes = (2..upperLimit).filter { isPrime(it.toBigInteger()) }
private val suitablePrimes = primes.filter { it.isSetOfTwoPrimes() }

fun main() {
    val min = (0..primes.size - 5).map { findSum(mutableListOf(primes[it])) }.filter { it != -1L }.min()
    println(min)
    kotlin.system.exitProcess(0)
}

fun findSum(p: MutableList<Long>, targetLength: Int = 3): Long {
    return when (p.size) {
        targetLength + 1 -> {
            p.sum()
        }

        else -> {
            var count = 1
            label@ while (primes.indexOf(p.last()) + count < primes.size) {
                val candidate = mutableListOf<Long>()
                candidate.addAll(p)
                val next = primes[primes.indexOf(p.last()) + count]
                candidate.add(next)
                val indices = getPermutedIndices(p.size)
                if (indices.any { (a, b) ->
                        val canA = candidate[a].toInt()
                        val canB = candidate[b].toInt()
                        !suitablePrimes.contains("$canA$canB".toLong())
                                || !suitablePrimes.contains("$canB$canA".toLong())
                    }) {
                    count++
                    continue@label
                } else {
                    if (findSum(candidate) != -1L) {
                        println(candidate)
                        return findSum(candidate)
                    } else {
                        count++
                        continue@label
                    }
                }
            }
            return -1
        }
    }
}

// nP2 = n * (n-1)
fun getPermutedIndices(n: Int): List<List<Int>> {
    if (n <= 1) return emptyList()
    return (0..<n).flatMap { a ->
        val remaining = (0..<n).toMutableList()
        remaining.remove(a)
        remaining.map { b ->
            listOf(a, b)
        }
    }
}

fun Long.isSetOfTwoPrimes(): Boolean {
    val s = this.toString()
    return when (val length = s.length) {
        1 -> false
        else -> (1..<length).any { i ->
            val first = s.substring(0, i)
            val second = s.substring(i, length)
            isPrime(first.toBigInteger())
                    && second[0] != '0' // prime must not begin with 0
                    && isPrime(second.toBigInteger())
                    && isPrime("$second$first".toBigInteger())
        }
    }
}