package exercises.unsolved

import functions.optimizedFactory
import java.math.BigInteger
import kotlin.math.pow

private val factories = mutableListOf<BigInteger>()

fun main() {
    (0..9).forEach { n -> factories.add(optimizedFactory(n)) }
    var count = BigInteger.ONE
    val numbers = mutableListOf<BigInteger>()

    while (count <= BigInteger.valueOf(1_000_000_000)) {
        if (digitsToFactorialSum(count) == count) numbers.add(count)
        count++
    }
    println(numbers)
    kotlin.system.exitProcess(0)
}

// Upper limit seems to be 9!

fun digitsToFactorialSum(number: BigInteger): BigInteger {
    return number.toString().map { factories[it.digitToInt()] }.sumOf { it }
}