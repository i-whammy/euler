package exercises.to60

import functions.isPalindromic
import java.math.BigInteger

// https://projecteuler.net/problem=55

fun main() {
    println(getAllLychrelNumbers(10_000).size)
    kotlin.system.exitProcess(0)
}

fun getAllLychrelNumbers(below: Long): List<Long> {
    return (1..below).filter { it.isLycrel() }
}

fun Long.isLycrel(): Boolean {
    var current = this.toBigInteger()
    var count = 0
    while (count < 50) {
        current += current.reversed()
        if (isPalindromic(current)) return false
        count++
    }
    return true
}

fun BigInteger.reversed() = this.toString().reversed().toBigInteger()