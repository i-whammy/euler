package exercises.to20

import java.math.BigInteger
import kotlin.system.exitProcess

// // https://projecteuler.net/problem=12

fun main() {
    println(firstTriangleNumberHavingDivisorsOver(500))
    exitProcess(0)
}

fun firstTriangleNumberHavingDivisorsOver(number: Int): BigInteger {
    var triangleNumber: BigInteger
    var divisorsCount: Int
    var inc = BigInteger.ONE
    var sum = BigInteger.ZERO
    do {
        sum += inc
        triangleNumber = sum
        divisorsCount = sum.getDivisorsCount()
        inc++
    } while (divisorsCount < number)
    return triangleNumber
}

fun BigInteger.getDivisorsCount(): Int {
    var divisorsCount = 0
    var i = BigInteger.ONE
    do {
        if (this % i == BigInteger.ZERO) divisorsCount++
        i++
    } while (i <= this.sqrt())
    return if (divisorsCount % 2 == 1) divisorsCount * 2 - 1 else divisorsCount * 2
}