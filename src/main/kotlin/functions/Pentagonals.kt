package functions

import kotlin.math.pow

fun pentagonals(size: Int): List<Long> {
    return (1..size).map { ((it.toDouble().pow(2) * 3 - it).toInt() / 2).toLong() }
}
