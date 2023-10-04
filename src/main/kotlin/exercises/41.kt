package exercises

import functions.isPrime
import kotlin.math.pow

fun main() {
    val start = System.currentTimeMillis()
    val answers = getAllPandigitals(1234567).filter { isPrime(it.toBigInteger()) }
    println("Time: ${System.currentTimeMillis() - start} ms")
    println(answers.max())
    kotlin.system.exitProcess(0)
}

fun getAllPandigitals(digit: Int): List<Int> {
    return permutations(digit)
}

fun permutations(digit: Int, answer: Int = 0, acc: MutableList<Int> = mutableListOf()): List<Int> {
    when (digit) {
        0 -> acc.add(answer)
        else -> {
            repeat(digit.toString().length) { i ->
                val rem = digit % 10.0.pow(i + 1).toInt() / (10.0.pow(i).toInt())
                val div = (digit / 10.0.pow(i + 1).toInt()) * 10.0.pow(i).toInt() + digit % 10.0.pow(i).toInt()
                permutations(div, answer * 10 + rem, acc)
            }
        }
    }
    return acc
}
