package exercises

import functions.isPrime
import java.math.BigDecimal

fun main() {
    println("Sum of primes below 10 is ${sumOfPrimesBelow(10)}")
    println("Sum of primes below 2_000_000 is ${sumOfPrimesBelow(2_000_000)}")
}

fun sumOfPrimesBelow(number: Long): BigDecimal {
    return (1..number).filter { isPrime(it) }.reduce { acc, i -> acc + i }.toBigDecimal()
}