package exercises.to20

import kotlin.system.exitProcess

// https://projecteuler.net/problem=1

fun main() {
    val target = (1..999).toList()
    println(multiplesOf3And5(target))
    exitProcess(0)
}

fun multiplesOf3And5(numbers: List<Int>): Int {
    return numbers.filter { it % 3 == 0 || it % 5 == 0 }
        .reduce { acc, i -> acc + i }
}