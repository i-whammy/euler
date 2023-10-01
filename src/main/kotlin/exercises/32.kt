package exercises

import functions.isPandigital
import java.math.BigInteger

// https://projecteuler.net/problem=32

fun main() {
    println(getPandigitalProducts().reduce { acc, i -> acc + i })
    kotlin.system.exitProcess(0)
}

fun getPandigitalProducts(): Set<BigInteger> {
    val targets = (1..9999L).filter { isPandigital(it) }
    return targets
        .map { a ->
            targets
                .filter { b -> isPandigitalProduct(a, b) }
                .map { a.toBigInteger() * it.toBigInteger() }
        }.flatten()
        .toSet()
}

fun isPandigitalProduct(a: Long, b: Long): Boolean {
    val product = a.toBigInteger() * b.toBigInteger()
    val all = a.toString() + b.toString() + product.toString()
    return isPandigital(all.toLong()) && all.length == 9
}
