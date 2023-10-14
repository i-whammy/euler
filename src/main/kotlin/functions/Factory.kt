package functions

import java.math.BigInteger

fun factory(below: Int): BigInteger {
    return when (below) {
        0 -> BigInteger.ONE
        1 -> BigInteger.ONE
        else -> below.toBigInteger() * factory(below - 1)
    }
}

fun optimizedFactory(below: Int, answer: BigInteger = BigInteger.ONE): BigInteger {
    return when (below) {
        0 -> BigInteger.ONE
        1 -> answer
        else -> optimizedFactory(below-1, answer * below.toBigInteger())
    }
}