package exercises.unsolved

import functions.optimizedFactory
import java.math.BigInteger

private val factories = mutableListOf<BigInteger>()

// Below 10_000_000_000, there are only 3 numbers which satisfy the condition. 1,2,145
// Summing up approach seems to be unrealistic because it takes more than 10 minutes to find the answer above!
fun main() {
    (0..9).forEach { n -> factories.add(optimizedFactory(n)) }
    var count = BigInteger.ONE
    val answers = mutableListOf<BigInteger>()

    while (count <= BigInteger.valueOf(10_000_000_000)) {
        if (digitsToFactorialSum(count) == count) answers.add(count)
        count++
    }
    println(answers)
    kotlin.system.exitProcess(0)
}

fun digitsToFactorialSum(number: BigInteger): BigInteger {
    val answer = number.toString().map { factories[it.digitToInt()] }.sumOf { it }
//    println("number $number => $answer")
    return answer
}