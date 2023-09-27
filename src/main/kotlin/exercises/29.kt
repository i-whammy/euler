package exercises

// https://projecteuler.net/problem=29

import java.math.BigInteger

fun main() {
    println(getUniquePowers(2,5,2,5).size)
    println(getUniquePowers(2,100,2,100).size)
    kotlin.system.exitProcess(0)
}

fun getUniquePowers(aFrom: Int, aTo: Int, bFrom: Int, bTo: Int): Set<BigInteger> {
    return (aFrom..aTo).map { a ->
        (bFrom..bTo).map { b ->
            a.toBigDecimal().pow(b).toBigInteger()
        }
    }.flatten().toSet()
}