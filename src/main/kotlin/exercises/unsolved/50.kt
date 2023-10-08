package exercises.unsolved

import functions.isPrime

fun main() {
    val primes = (1..1_000_000).filter { isPrime(it.toBigInteger()) }
    val upperLimit = primes.last()
    var consecutives = 21 // below 1000, the longest consecutive terms is 21.
    primes.forEachIndexed { index, _ ->
        val list = primes.toMutableList()
        repeat(index) { list.removeFirst() }
        var sum = 0
        var times = 0
        while (sum < upperLimit) {
            sum += list.first()
            times++
            if (isPrime(sum.toBigInteger()) && times > consecutives) consecutives = times
        }
    }
    println(consecutives)
    kotlin.system.exitProcess(0)
}