package exercises

import functions.isPrime
import java.math.BigInteger

fun main() {
    val answer = (11..1_000_000).map { it.toBigInteger() }
        .filter { it.isTrancatableFromLeftToRight() && it.isTrancatableFromRightToLeft() }.sumOf { it }
    println(answer)
    kotlin.system.exitProcess(0)
}

fun BigInteger.isTrancatableFromLeftToRight(): Boolean {
    val digits = this.toString()
    val digitsNumber = digits.length
    return (0..<digitsNumber).map { i -> digits.substring(i, digitsNumber).toBigInteger() }.all { isPrime(it) }
}

fun BigInteger.isTrancatableFromRightToLeft(): Boolean {
    val digits = this.toString()
    val digitsNumber = digits.length
    return (1..digitsNumber).map { i -> digits.substring(0, i).toBigInteger() }.all { isPrime(it) }
}