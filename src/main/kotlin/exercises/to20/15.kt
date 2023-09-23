package exercises.to20

import java.math.BigInteger
import kotlin.system.exitProcess

// https://projecteuler.net/problem=15

fun main() {
    println(getRoutesCountOfGrid(BigInteger.valueOf(2), BigInteger.valueOf(2)))
    println(getRoutesCountOfGrid(BigInteger.valueOf(20), BigInteger.valueOf(20)))
    exitProcess(0)
}

fun getRoutesCountOfGrid(x: BigInteger, y: BigInteger): BigInteger {
    val pPatterns = (0..<x.toInt()).map { x + y - it.toBigInteger() }.reduce { acc, num -> acc * num }
    val divisor = (0..<y.toInt()).map { y - it.toBigInteger() }.reduce { acc, num -> acc * num }
    return pPatterns / divisor
}