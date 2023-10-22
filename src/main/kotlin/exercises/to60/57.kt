package exercises.to60

import java.math.BigInteger

fun main() {
    val count = (1..1000).map { getIteratedFraction(it).plusOne() }.count { it.isNumeratorDigitsGreater() }
    println(count)
    kotlin.system.exitProcess(0)
}

fun getIteratedFraction(iterationTime: Int): Fraction {
    val base = Fraction(BigInteger.valueOf(1), BigInteger.valueOf(2))
    return when (iterationTime) {
        1 -> base
        else -> getIteratedFraction(iterationTime - 1).inverse()
    }
}

data class Fraction(val numerator: BigInteger, val denominator: BigInteger) {
    fun isNumeratorDigitsGreater() = numerator.toString().length > denominator.toString().length
    fun plusOne() = Fraction(this.numerator + this.denominator, this.denominator)
    fun inverse() = this.let { Fraction(it.denominator * 2.toBigInteger() + it.numerator, it.denominator) }
        .let { Fraction(it.denominator, it.numerator) }
}