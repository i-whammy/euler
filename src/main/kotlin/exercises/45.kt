package exercises

import kotlin.math.pow

fun main() {
    var answer = 0
    println(hexagonals(50000).subList(143,50000).first { isTriangle(it) && isPentagonal(it) })
    kotlin.system.exitProcess(0)
}

fun hexagonals(size: Int): List<Long> {
    return (1..size).map { 2 * it.toDouble().pow(2).toInt() - it.toLong() }
}

fun isTriangle(n: Long): Boolean {
    when (n) {
        1L -> return true
        else -> {
            var sum = 1L
            var i = 1
            while (sum < n) {
                sum += i + 1
                if (sum == n) return true
                i++
            }
            return false
        }
    }
}
