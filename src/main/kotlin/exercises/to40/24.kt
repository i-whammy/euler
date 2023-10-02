package exercises.to40

// https://projecteuler.net/problem=24

import functions.factory

private const val digits = "0123456789"

fun main() {
    val result = getLexicographicPermutations(digits, 1_000_000)
    println(result)
    kotlin.system.exitProcess(0)
}

fun getLexicographicPermutations(digits: String, index: Int): String {
    val actualIndexNumber = index - 1
    val mutableDigits = digits.toMutableList()
    val indices = mutableListOf<Int>()
    (digits.length downTo 2).forEach { i ->
        indices.add((actualIndexNumber % factory(i).toInt()) / factory(i-1).toInt())
    }
    var result = ""
    indices.forEach {
        result += mutableDigits[it]
        mutableDigits.removeAt(it)
    }
    result += digits.first { !result.contains(it) }
    return result
}