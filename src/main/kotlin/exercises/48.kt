package exercises

import java.math.BigInteger

fun main() {
    var sum = BigInteger.ZERO
    (1..1000).forEach { i ->
        sum += i.toBigInteger().pow(i)
    }
    println(sum % BigInteger.valueOf(10_000_000_000))
    kotlin.system.exitProcess(0)
}