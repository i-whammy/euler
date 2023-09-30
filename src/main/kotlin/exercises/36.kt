package exercises

import functions.isPalindromic

// https://projecteuler.net/problem=36

fun main() {
    val answers = (1..1_000_000).filter { isPalindromic(it) && isBinaryPalindromic(it) }
    println(answers.sum())
    kotlin.system.exitProcess(0)
}

fun isBinaryPalindromic(number: Int): Boolean {
    val binaryString = Integer.toBinaryString(number)
    return binaryString.toBigInteger().let { isPalindromic(it) }
}
