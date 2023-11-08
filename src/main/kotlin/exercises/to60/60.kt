package exercises.to60

import functions.isPrime
import kotlin.math.min
import kotlin.math.sign

private const val upperLimit = 100_000
private val primes =
    (3..upperLimit).filter { isPrime(it.toBigInteger()) } // 2 is prime, but it will create even numbers so omit it.

fun main() {
    println(findMinimumSumOfPrimeSets(5))
    kotlin.system.exitProcess(0)
}

fun findMinimumSumOfPrimeSets(n: Int): Int {
    val primeChains = mutableMapOf<Int, List<List<Int>>>()
    var tmpSum = 0
    var index = 0
    while (index < primes.size) {
        val current = primes[index]
        val candidates = (0..<index).map { primes[it] }.filter { areConcatPrimes(current, it) }
        val newChains = mutableListOf<List<Int>>()
        candidates.forEach { prime ->
            val chains = primeChains[prime]
            if (chains.isNullOrEmpty()) {
                newChains.add(listOf(prime, current))
            } else {
                chains.forEach { chain ->
                    val newChain = chain.toMutableList()
                    if (newChain.all { candidates.contains(it) }) {
                        newChain.add(current)
                        newChains.add(newChain)
                        if (newChain.size == n) {
                            println(newChain)
                            tmpSum = newChain.sum()
                        }
                    }
            }}
        }
        primeChains[current] = newChains
        index++
        if (tmpSum != 0) break
    }
    while (primes[index-1] < tmpSum) {
        val current = primes[index-1]
        val candidates = (0..<index).map { primes[it] }.filter { areConcatPrimes(current, it) }
        val newChains = mutableListOf<List<Int>>()
        candidates.forEach { prime ->
            val chains = primeChains[prime]
            if (chains.isNullOrEmpty()) {
                newChains.add(listOf(prime, current))
            } else {
                chains.forEach { chain ->
                    val newChain = chain.toMutableList()
                    if (newChain.all { candidates.contains(it) }) {
                        newChain.add(current)
                        newChains.add(newChain)
                        if (newChain.size == n) {
                            println(newChain)
                            tmpSum = min(tmpSum, newChain.sum())
                        }
                    }
                }
            }
        }
        primeChains[current] = newChains
        index++
    }
    return tmpSum
}

fun areConcatPrimes(a: Int, b: Int): Boolean = isPrime("$a$b".toBigInteger()) && isPrime("$b$a".toBigInteger())