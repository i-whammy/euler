package exercises

import functions.isPrime

private val digits = (0..9).toList()

fun main() {
    val oddPrimePermutations = oddNumberPermutations().filter { isPrime(it.toBigInteger()) }
    toPermutationPair(oddPrimePermutations).filter {
        isEvenlyIncreasingNumbers(oddPrimePermutations, it)
                && isPermutationNumbers(it)
    }.forEach { println("${it.first}${(it.first + it.second) / 2}${it.second}") }
    kotlin.system.exitProcess(0)
}

private fun isEvenlyIncreasingNumbers(
    oddPrimePermutations: List<Int>,
    it: Pair<Int, Int>
) = oddPrimePermutations.contains((it.first + it.second) / 2)

private fun isPermutationNumbers(numbers: Pair<Int, Int>): Boolean {
    val (a, c) = numbers
    val b = (a + c) / 2
    return "$a".toList().sorted() == "$b".toList().sorted() && "$a".toList().sorted() == "$c".toList().sorted()
}

fun oddNumberPermutations(): List<Int> {
    return (1..9).map { a ->
        digits.map { b ->
            digits.map { c ->
                (1..9 step 2).map { d ->
                    a * 1000 + b * 100 + c * 10 + d
                }
            }.flatten()
        }.flatten()
    }.flatten()
}

fun toPermutationPair(numbers: List<Int>): List<Pair<Int, Int>> {
    return numbers.map { a ->
        val numbersWithoutA = numbers.toMutableList()
        numbersWithoutA.remove(a)
        numbersWithoutA.map { b ->
            a to b
        }
    }.flatten()
}