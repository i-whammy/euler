package functions

import kotlin.math.sqrt

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