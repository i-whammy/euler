package functions

import kotlin.math.pow

fun pentagonals(size: Int): List<Long> {
    return (1..size).map { pentagonal(it) }
}

fun pentagonal(n: Int) = ((n.toDouble().pow(2) * 3 - n).toInt() / 2).toLong()