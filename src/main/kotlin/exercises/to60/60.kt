package exercises.to60

import functions.isPrime
import kotlin.math.min

private const val upperLimit = 100_000
private val primes =
    (3..upperLimit).filter { isPrime(it.toBigInteger()) } // 2 is prime, but it will create even numbers so omit it.

fun main() {
    println(findMinimumSumOfPrimeSets(4))
    kotlin.system.exitProcess(0)
}

fun findMinimumSumOfPrimeSets(n: Int): Int {
    val primeMap = mutableMapOf<Int, List<Int>>()
    var tmpSum: Int
    var index = 0
    while (true) {
        val current = primes[index]
        val candidates = (0..<index).map { primes[it] }.filter { areConcatPrimes(current, it) }
        primeMap[current] = candidates
        candidates.map { candidate ->
            val cands = primeMap[candidate]!!
            cands.filter {
                cands.any { cand -> primeMap[it]!!.contains(cand) }
            }
        }
        var count = n - 1
        val filtered = mutableListOf(current)
        candidates.reversed().forEachIndexed { i, candidate ->
            val remainings = candidates.subList(0, i)
            if (remainings.count { e ->
                    primeMap[e]?.contains(candidate) == true
                } == count
            ) {
                filtered.add(candidate)
                count--
            }
        }
        if (filtered.size == n) {
            tmpSum = filtered.sum()
            println("$filtered")
            println("tmpSum = $tmpSum")
            break
        }
        index++
        continue
    }
    while (primes[index] < tmpSum) {
        val current = primes[index]
        val candidates = (0..<index).map { primes[it] }.filter { areConcatPrimes(current, it) }
        primeMap[current] = candidates
        var count = n - 1
        val filtered = mutableListOf(current)
        candidates.reversed().forEachIndexed { i, candidate ->
            val remainings = candidates.subList(0, i)
            if (remainings.count { e ->
                    primeMap[e]?.contains(candidate) == true
                } == count
            ) {
                filtered.add(candidate)
                count--
            }
        }
        if (filtered.size == n) {
            tmpSum = min(filtered.sum(), tmpSum)
            println("$filtered")
            println("tmpSum = $tmpSum")
        }
        index++
        continue
    }
    return tmpSum
}

fun areConcatPrimes(a: Int, b: Int): Boolean = isPrime("$a$b".toBigInteger()) && isPrime("$b$a".toBigInteger())