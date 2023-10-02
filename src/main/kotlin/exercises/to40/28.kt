package exercises.to40

// https://projecteuler.net/problem=28

import java.math.BigInteger
import kotlin.math.pow

fun main() {
    println(sumDiagonalsInSpiral(1001))
    kotlin.system.exitProcess(0)
}

fun sumDiagonalsInSpiral(spiral: Int): BigInteger {
    val answer = BigInteger.ONE
    return (3..spiral step 2)
        .map { s ->
            val spiralStart = (s - 2).toDouble().pow(2).toInt() + 1
            val spiralEnd = s.toDouble().pow(2).toInt()
            (spiralStart..spiralEnd).filter { it % (s - 1) == 1 }.sum().toBigInteger()
        }
        .reduce { acc, i -> acc + i }.plus(answer)
}