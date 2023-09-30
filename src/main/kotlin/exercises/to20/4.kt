package exercises.to20

import functions.isPalindromic
import kotlin.system.exitProcess

// https://projecteuler.net/problem=4

fun main() {
    println(largestPalindromeProduct())
    exitProcess(0)
}

fun largestPalindromeProduct(): Long {
    var a = 100L
    var b = 100L
    var max = 0L
    while (a < 1000) {
        while (b < 1000) {
            if (isPalindromic(a * b) && max < a * b) {
                max = a * b
            }
            b += 1
        }
        a += 1
        b = 100
    }
    return max
}
