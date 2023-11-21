package exercises

import java.math.BigInteger
import kotlin.math.sqrt

private val border = BigInteger.valueOf(1_000_000_000_000L)

fun main() {
    val total = border
    val blue = BigInteger.ZERO
//    println(solveWithBrutalWay(total, blue))
    println(solveWithQuadEquation())
    kotlin.system.exitProcess(0)
}

private fun solveWithBrutalWay(t: BigInteger, b: BigInteger): BigInteger {
    var total = t
    var blue = b
    while (blue == BigInteger.ZERO) {
        var tempBlue = total.div(BigInteger.valueOf(2L))
        while (tempBlue != total) {
            if (tempBlue * (tempBlue - BigInteger.ONE) * BigInteger.valueOf(2L) == total * (total - BigInteger.ONE)) {
                blue = tempBlue
                return blue
            }
            tempBlue++
        }
        total++
        println(total)
    }
    throw RuntimeException("")
}

private fun solveWithQuadEquation(): BigInteger {

    val x0 = BigInteger.valueOf(3)
    val y0 = BigInteger.valueOf(1)

    var x = x0
    var y = y0

    while (true) {
        val sqrt: BigInteger = sqrt(y.multiply(y).multiply(BigInteger.valueOf(8)).add(BigInteger.ONE).toDouble()).toBigDecimal().toBigInteger()
        if (sqrt.testBit(0)) {
            val blue = sqrt.add(BigInteger.ONE).divide(BigInteger.valueOf(2)).add(y)
            if (blue.add(y) > BigInteger.TEN.pow(12)) return blue
        }

        val nextx = x.multiply(x0).add(y.multiply(y0).multiply(BigInteger.valueOf(8)))
        val nexty = x.multiply(y0).add(y.multiply(x0))
        x = nextx
        y = nexty
    }}
