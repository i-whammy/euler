package exercises.to40

import kotlin.math.pow

// https://projecteuler.net/problem=40

fun main() {
//    println(solveWithBrutalWay())
    println(solveWithSmartWay())
    kotlin.system.exitProcess(0)
}

fun solveWithBrutalWay(): Int {
    val upperLimit = 1_000_000
    var fractionParts = ""
    var i = 1
    while (fractionParts.length < upperLimit) {
        fractionParts += i
        i++
    }
    return listOf(
        fractionParts[0],
        fractionParts[9],
        fractionParts[99],
        fractionParts[999],
        fractionParts[9999],
        fractionParts[99999],
        fractionParts[999999]
    )
        .map { it.digitToInt() }
        .reduce { acc, it -> acc * it }
}

fun solveWithSmartWay(): Int {
    return listOf(
        findNthNumber(1),
        findNthNumber(10),
        findNthNumber(100),
        findNthNumber(1000),
        findNthNumber(10000),
        findNthNumber(100000),
        findNthNumber(1000000)
    )
        .reduce { acc, it -> acc * it }
}

// Returns the positive number which contains nth index.
fun findNthDigitPositiveInteger(n: Int): Int {
    return if (n < 10) n
    else if (n < 100) (n - maximumDigitsIndex(1) + 1) / 2 + 9
    else if (n < 1000) (n - maximumDigitsIndex(2) + 2) / 3 + 99
    else if (n < 10000) (n - maximumDigitsIndex(3) + 3) / 4 + 999
    else if (n < 100000) (n - maximumDigitsIndex(4) + 4) / 5 + 9999
    else (n - maximumDigitsIndex(5) + 5) / 6 + 99999
}

// Returns the maximum index number for the certain digit.
// e.g. As per 1-digit number, the maximum index is 9, so returns it.
// As per 2-digit number, the maximum index is 189, so returns it.
fun maximumDigitsIndex(digit: Int, acc: Int = 0): Int {
    return when (digit) {
        0 -> acc
        else -> maximumDigitsIndex(digit - 1, acc + 10.0.pow(digit - 1).toInt() * digit * 9)
    }
}

// Returns the remainder index
fun findNthRemainder(n: Int): Int {
    val digit = findNthDigitPositiveInteger(n).toString().length
    return (n - maximumDigitsIndex(digit - 1) - 1) % digit
}

fun findNthNumber(n: Int): Int {
    if (n < 10) return n
    val positiveInteger = findNthDigitPositiveInteger(n)
    val remainder = findNthRemainder(n)
    return positiveInteger.toString()[remainder].digitToInt()
}