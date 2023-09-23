package exercises

// https://projecteuler.net/problem=21

import functions.getProperDivisorsOf
import kotlin.system.exitProcess

private val sumOfProperDivisors = mutableListOf<Int>()

fun main() {
    println(sumUp(10000))
    exitProcess(0)
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
