package exercises

import kotlin.math.pow

// https://projecteuler.net/problem=9

fun main() {
    // a + b + c = 1000
    // c = 1000 - (a + b)
    // a < b < c
    // a^2 + b^2 = c^2
    val answers = mutableListOf<Int>()
    (1..332).forEach { a ->
        (1..499).forEach { b ->
            val i = powDouble(a) + powDouble(b)
            val i1 = powDouble(1000 - ( a + b))
            if (i == i1) {
                answers.add(a)
                answers.add(b)
                answers.add(1000 - a - b)
            }
        }
    }
    println(answers.reduce { acc, i -> acc * i })
}

fun powDouble(a: Int): Int = a.toDouble().pow(2).toInt()