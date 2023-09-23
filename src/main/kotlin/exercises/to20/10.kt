package exercises.to20

import functions.isPrime
import java.math.BigDecimal
import kotlin.system.exitProcess

// https://projecteuler.net/problem=10

fun main() {
    println("Sum of primes below 10 is ${sumOfPrimesBelow(10)}")
    println("Sum of primes below 2_000_000 is ${sumOfPrimesBelow(2_000_000)}")
    exitProcess(0)
}

fun sumOfPrimesBelow(number: Long): BigDecimal {
    return (1..number).filter { isPrime(it) }.reduce { acc, i -> acc + i }.toBigDecimal()
}