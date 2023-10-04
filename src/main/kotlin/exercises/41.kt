package exercises

import functions.isPrime
import functions.permutations

fun main() {
    val start = System.currentTimeMillis()
    val answers = getAllPandigitals(1234567).filter { isPrime(it.toBigInteger()) }
    println("Time: ${System.currentTimeMillis() - start} ms")
    println(answers.max())
    kotlin.system.exitProcess(0)
}

fun getAllPandigitals(digit: Long): List<Long> {
    return permutations(digit)
}
