package exercises.to40

// https://projecteuler.net/problem=37

import functions.isPrime

fun main() {
    val answer = (11..1_000_000L)
        .filter { it.isTruncatableFromLeftToRight() && it.isTruncatableFromRightToLeft() }.sumOf { it }
    println(answer)
    kotlin.system.exitProcess(0)
}

fun Long.isTruncatableFromLeftToRight(): Boolean {
    val digits = this.toString()
    val digitsNumber = digits.length
    return (0..<digitsNumber).map { i -> digits.substring(i, digitsNumber).toBigInteger() }.all { isPrime(it) }
}

fun Long.isTruncatableFromRightToLeft(): Boolean {
    val digits = this.toString()
    val digitsNumber = digits.length
    return (1..digitsNumber).map { i -> digits.substring(0, i).toBigInteger() }.all { isPrime(it) }
}