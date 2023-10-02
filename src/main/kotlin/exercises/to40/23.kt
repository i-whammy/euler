package exercises.to40

import functions.getProperDivisorsOf

// https://projecteuler.net/problem=23

fun main() {
    val target = 1..28122
    val abundantNumbers = target.filter { it.isAbundant() }
    val abundantSums = mutableSetOf<Int>()
    abundantNumbers.forEach { a ->
        abundantNumbers.forEach { b ->
            abundantSums.add(a + b)
        }
    }
    val sum = target.filter { !abundantSums.contains(it) }.sum()
    println(sum)
    kotlin.system.exitProcess(0)
}

fun Int.isAbundant(): Boolean {
    val divisors = getProperDivisorsOf(this)
    return divisors.sum() > this
}
