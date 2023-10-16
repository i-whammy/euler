package exercises

import java.math.BigInteger

fun main() {
    var max = 0
    (1..99).forEach { a ->
        (1..99).forEach { b ->
            val sum = a.toBigInteger().pow(b).sumUp()
            max = maxOf(sum, max)
        }
    }
    println(max)
    kotlin.system.exitProcess(0)
}

fun BigInteger.sumUp() = this.toString().fold(0) { acc, c -> acc + c.digitToInt() }