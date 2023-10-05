package exercises

import functions.getDigitPermutations

private val primes = listOf(2,3,5,7,11,13,17)

fun main() {
    val pandigitals = getDigitPermutations(1234567890).filter { it / 1_000_000_000 >= 1 }
    println(pandigitals.filter { isSubstringDivisible(it) }.sum())
    kotlin.system.exitProcess(0)
}

fun isSubstringDivisible(n: Long): Boolean {
    return (0..6).all { n.toString().substring(it + 1, it + 4).toInt() % primes[it] == 0 }
}