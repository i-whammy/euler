package exercises

//https://projecteuler.net/problem=6

import java.math.BigDecimal

fun main() {
    println(getSumSquareUntil(100) - getSquareSumUntil(100))
}

fun getSquareSumUntil(number: Int): BigDecimal {
    return (1..number).map { it * it }.reduce { acc, i -> acc + i }.toBigDecimal()
}

fun getSumSquareUntil(number: Int): BigDecimal {
    val i = (1 + number) * number / 2
    return (i * i).toBigDecimal()
}