package exercises.to60

import functions.isPrime

private const val upperLimit = 1_000_000L
private val primes = (3..upperLimit).filter { isPrime(it.toBigInteger()) } // 2 is prime but it will create even numbers so omit it.
private val suitablePrimes = primes.filter { it.isSetOfTwoPrimes() }

fun main() {
    val min = primes.map { findSum(mutableListOf(it)) }.filter { it != -1L }.min()
    println(min)
    kotlin.system.exitProcess(0)
}

fun findSum(resultPrimes: MutableList<Long>, targetLength: Int = 3): Long {
    when (resultPrimes.size) {
        targetLength + 1 -> {
            println(resultPrimes)
            return resultPrimes.sum()
        }

        else -> {
            (1..<primes.indexOf(resultPrimes.last())).map { count ->
                val candidates = mutableListOf<Long>().also { it.addAll(resultPrimes) }
                candidates.add(primes[primes.indexOf(resultPrimes.last()) + count])
                candidates
            }.filterNot { candidate ->
                val indices = getPermutedIndices(candidate.size)
                indices.any { (a, b) ->
                    val canA = candidate[a].toInt()
                    val canB = candidate[b].toInt()
                    !suitablePrimes.contains("$canA$canB".toLong())
                            || !suitablePrimes.contains("$canB$canA".toLong())
                }
            }.forEach {
                findSum(it)
            }
        }
    }
    return -1
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