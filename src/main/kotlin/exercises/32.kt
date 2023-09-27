package exercises

import java.math.BigInteger

// https://projecteuler.net/problem=32

fun main() {
    println(getPandigitalProducts().reduce { acc, i -> acc + i })
    kotlin.system.exitProcess(0)
}

fun getPandigitalProducts(): Set<BigInteger> {
    val targets = (1..9999).filter { isDigitalUniquePandigital(it) }
    return targets
        .map { a ->
            targets
                .filter { b -> isPandigitalProduct(a, b) }
                .map { a.toBigInteger() * it.toBigInteger() }
        }.flatten()
        .toSet()
}

fun isPandigitalProduct(a: Int, b: Int): Boolean {
    val product = a.toBigInteger() * b.toBigInteger()
    val all = a.toString() + b.toString() + product.toString()
    val set = all.toSet()
    return all.length == set.size
            && set.size == 9
            && set.none { it == '0' }
}

fun isDigitalUniquePandigital(a: Int): Boolean {
    val set = a.toString().toSet()
    return set.size == a.toString().length && !set.contains('0')
}