package exercises.unsolved

import functions.isPrime

fun main() {
    var maxA = -999L
    var maxB = -1000L
    var maxN = 0L
    (-999..999L).map { a ->
        (-1000..1000L).map { b ->
            var n = 0L
            while (doCalculation(n,a,b).isNotDivisible()) {
                n++
            }
            if (maxN < n) {
                println("n became $n")
                maxN = n
                maxA = a
                maxB = b
            }
        }
    }
    println(maxA)
    println(maxB)
    println(maxN)
    kotlin.system.exitProcess(0)
}

fun Long.isNotDivisible() = this >= 0L && (isPrime(this.toBigInteger()) || this == 1L)

fun doCalculation(n: Long, a: Long, b: Long): Long = n * n + a * n + b