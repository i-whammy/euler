package exercises

import exercises.to20.pow
import functions.isPrime

fun main() {
    val diagonals = mutableListOf(1)
    val primes = mutableListOf<Int>()
    var sideLength = 1
    while (true) {
        sideLength += 2
        val lastTotalNumbersCount = totalNumbersCount(sideLength - 2)
        (1..4).forEach { x ->
            val diagonal = (sideLength - 1) * x + lastTotalNumbersCount
            diagonals.add(diagonal)
            if (isPrime(diagonal.toBigInteger())) primes.add(diagonal)
        }
        if (primes.size * 10 < diagonals.size) break
    }
    println(sideLength)
    kotlin.system.exitProcess(0)
}

fun totalNumbersCount(sideLength: Int): Int {
    when (sideLength % 2) {
        1 -> return sideLength.pow(2).toInt()
        else -> throw RuntimeException()
    }
}