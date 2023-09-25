package exercises

import java.math.BigInteger

fun main() {
    println(fibonacciIndex(1000))
    kotlin.system.exitProcess(0)
}

fun fibonacciIndex(digits: Int): Int {
    var i = 0
    var continues = true
    while (continues) {
        i++
        if (fibonacci(i).toString().length >= digits) continues = false
    }
    return i
}

// This is a brutal solution that takes sooooo much long time.
fun brutalFibonacci(index: Int): BigInteger {
    return when (index) {
        1,2 -> BigInteger.ONE
        else -> brutalFibonacci(index-1) + brutalFibonacci(index-2)
    }
}

fun fibonacci(index: Int): BigInteger {
    return if (index == 1 || index == 2) BigInteger.ONE
    else {
        var result = BigInteger.ZERO
        var f1 = BigInteger.ONE
        var f2 = BigInteger.ONE
        repeat((3..index).count()) {
            result = f1 + f2
            f2 = f1
            f1 = result
        }
        result
    }
}