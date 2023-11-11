package exercises.to80

import java.math.BigInteger
import kotlin.math.pow
import kotlin.math.sqrt

private const val UPPER_LIMIT = 100_000_000_00L
private val squares = (1..31).map { it.toDouble().pow(2).toLong() }

fun main() {
    val ds = (1..65L).filterNot { squares.contains(it) }
    var xMax = 3L
    var dMax = 2L
    ds.forEach first@{ d ->
        (1..UPPER_LIMIT).forEach { x ->
//            if (d == 61L) println(x)
            val y = sqrt((x.toDouble().pow(2) - 1) / d).toLong()

            if (y > 0 &&
                y.toDouble().pow(2).toLong() * d + 1 == x.toDouble().pow(2).toLong()) {
                if (areValid(x.toBigInteger(), y.toBigInteger(), d)) {
                    println("$x^2 - $d * $y^2 = 1")
                    if (xMax < x) {
                        xMax = x
                        dMax = d
                    }
                    return@first
                }
            }
        }
        println("omitted d = $d") // at least when d=61 x might be too big so that x is not determined
    }
    println(dMax)
    kotlin.system.exitProcess(0)
}

fun areValid(x: BigInteger, y: BigInteger, d: Long): Boolean {
    return (x.pow(2) - d.toBigInteger() * y.pow(2)) == BigInteger.ONE
}