package exercises.to80

import java.math.BigInteger

fun main() {
    val answers = mutableListOf<BigInteger>()
    (1..1000).forEach {
        var current = BigInteger.valueOf(1)
        while (current.pow(it).toString().length <= it) {
            if (current.pow(it).toString().length == it) {
                answers.add(current.pow(it))
            }
            current++
        }
    }
    println(answers.size)
    kotlin.system.exitProcess(0)
}