package functions

import java.math.BigInteger

fun factory(below: Int): BigInteger {
    return when (below) {
        1 -> BigInteger.ONE
        else -> BigInteger.valueOf(below.toLong()) * factory(below - 1)
    }
}