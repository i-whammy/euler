package exercises.to40

// https://projecteuler.net/problem=35

import functions.isPrime

fun main() {
    val answers = findCircularPrimes(1_000_000)
    println(answers.size)
    kotlin.system.exitProcess(0)
}

fun findCircularPrimes(below: Int): List<Int> {
    return (1..below).filter { isPrime(it.toBigInteger()) }
        .filter { it.isCircularPrime() }
}

fun Int.isCircularPrime(): Boolean {
    val digits = this.toString()
    val digitsNumber = digits.length
    return (1..digitsNumber).map {
        "${digits.substring(it - 1, digitsNumber)}${digits.substring(0, it - 1)}"
    }
        .all { isPrime(it.toBigInteger()) }
}