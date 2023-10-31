package exercises

import kotlin.math.sqrt

private const val UPPER_LIMIT_NUMERATOR = 1_000_000
private const val UPPER_LIMIT_FRACTION = 3 / 7.0

fun main() {
    var count = 2
    var max = 2 / 7.0
    var maxNumerator = 0
    while (count <= UPPER_LIMIT_NUMERATOR) {
        ((count * max).toInt() ..<(count * UPPER_LIMIT_FRACTION).toInt()).forEach { numerator ->
            if ((max..<UPPER_LIMIT_FRACTION).contains(numerator / count.toDouble())) {
                val gcm = getGCM(count, numerator)
                max = numerator / count.toDouble()
                maxNumerator = numerator / gcm
            }
        }
        count++
    }
    println(maxNumerator)
    kotlin.system.exitProcess(0)
}

fun getRelativePrimes(n: Int): List<Int> {
    val result = (1..n).toMutableList()
    val sqrt = sqrt(n.toDouble()).toInt()
    (2..sqrt).forEach { i ->
        var count = i
        while (i < n) {
            result.remove(count)
            count += i
        }
    }
    return result
}