import java.math.BigDecimal

// https://projecteuler.net/problem=5

fun main() {
    println(smallestMultipleUntil(20))
}

fun smallestMultipleUntil(number: Int): BigDecimal {
    val primes = mutableListOf<Int>()
    (1..number).filter { isPrime(it) }.forEach { primes.add(it) }
    return primes.map { getMaxMultipleUntil(it, number) }.reduce { acc, i -> acc * i }.toBigDecimal()
}

fun isPrime(number: Int): Boolean {
    if (number == 2) return true
    if (number == 1) return false
    else {
        var dividend = number - 1
        while (dividend >= 2) {
            if (number % dividend == 0) return false
            dividend -= 1
        }
        return true
    }
}

fun getMaxMultipleUntil(number: Int, limit: Int): Int {
    var result = 1
    while (true) {
        val temporaryResult = result * number
        if (temporaryResult > limit) break
        result = temporaryResult
    }
    return result
}