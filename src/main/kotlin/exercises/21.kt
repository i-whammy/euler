package exercises

// https://projecteuler.net/problem=21

import kotlin.math.sqrt

private val sumOfProperDivisors = mutableListOf<Int>()

fun main() {
    println(sumUp(10000))
}

fun sumUp(below: Int): Int {
    var sumOfAmicableNumbers = 0
    (1..below).forEach {
        sumOfProperDivisors.add(getProperDivisorsOf(it).sum())
    }
    sumOfProperDivisors.forEachIndexed { i, it -> println("Index: ${i}, Number: $it") }
    sumOfProperDivisors.forEachIndexed { i, b ->
        if (i + 1 != b
            && b <= sumOfProperDivisors.size
            && b > 0
            && sumOfProperDivisors[b - 1] == i + 1
        ) {
            sumOfAmicableNumbers += b
            println("d(${i + 1}) = $b")
        }
    }
    return sumOfAmicableNumbers
}

fun getProperDivisorsOf(number: Int): List<Int> {
    if (number == 1) return emptyList()
    val squareRoot = sqrt(number.toDouble()).toInt()
    val properDivisors = mutableListOf<Int>()
    (1..squareRoot).forEach {
        if (number % it == 0) {
            properDivisors.add(it)
            if (it * it != number && it != 1) {
                properDivisors.add(number / it)
            }
        }
    }
    return properDivisors
}
