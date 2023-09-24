package exercises.to20

import functions.factory
import java.math.BigInteger
import kotlin.system.exitProcess

fun main() {
    println(factory(100).let{ sumOfDigits(it) })
    exitProcess(0)
}

fun sumOfDigits(number: BigInteger): Int {
    return number.toString().map { it.toString().toInt() }.reduce { acc, i -> acc + i }
}