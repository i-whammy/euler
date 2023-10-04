package functions

import kotlin.math.pow

fun permutations(digit: Long, answer: Long = 0L, acc: MutableList<Long> = mutableListOf()): List<Long> {
    when (digit) {
        0L -> acc.add(answer)
        else -> {
            repeat(digit.toString().length) { i ->
                val rem = digit % 10.0.pow(i + 1).toLong() / (10.0.pow(i).toLong())
                val div = (digit / 10.0.pow(i + 1).toLong()) * 10.0.pow(i).toLong() + digit % 10.0.pow(i).toLong()
                permutations(div, answer * 10 + rem, acc)
            }
        }
    }
    return acc
}
