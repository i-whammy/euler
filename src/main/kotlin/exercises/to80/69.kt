package exercises.to80

import functions.totientsList

private const val limit = 1_000_000

fun main() {
    val answer = totientsList(limit).foldIndexed(MaxNAndFraction(0, 0.0)) { index, acc, n -> acc.confirm(index, n) }
    println(answer)
    kotlin.system.exitProcess(0)
}

fun areRelativePrime(a: Int, b: Int): Boolean {
    return getGCM(a, b) == 1
}

// GCM stands for greatest common divisor
fun getGCM(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (x % y != 0) {
        val tmpX = x
        x = y
        y = tmpX % y
    }
    return y
}

data class MaxNAndFraction(val n: Int, val fraction: Double) {
    fun confirm(n: Int, count: Int): MaxNAndFraction {
        return try {
            val fraction = n.toDouble() / count
            if (fraction > this.fraction) {
                MaxNAndFraction(n, fraction)
            } else this
        } catch (e: ArithmeticException) {
            this
        }
    }
}
