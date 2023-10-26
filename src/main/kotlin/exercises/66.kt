package exercises

import java.math.BigInteger
import kotlin.math.pow

private const val UPPER_LIMIT = 100_000L
private val squares = (1..31).map { it.toDouble().pow(2) }

fun main() {
    val ds = (1..1000L).filterNot { squares.contains(it.toDouble()) }
    var max = 1L
    var dMax = 0L
    ds.forEach first@{ d ->
        (1L..UPPER_LIMIT).forEach { x ->
            var y = BigInteger.ONE
            while (x.toBigInteger().pow(2) > y.pow(2) * BigInteger.valueOf(d)) {
                if (areValid(x, y, d)) {
//                    println("$x^2 - $d * $y^2 = 1")
                    if (max < x) {
                        max = x
                        dMax = d
                    }
                    return@first
                }
                y++
            }
        }
        println(d) // at least when d=61 x might be too big so that x is not determined
    }
    println(dMax)
    kotlin.system.exitProcess(0)
}

fun areValid(x: Long, y: BigInteger, d: Long): Boolean {
    return (x.toDouble().pow(2) - d * y.toDouble().pow(2)).toLong() == 1L
}