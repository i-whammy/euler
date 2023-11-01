package exercises

import functions.totientsList

fun main() {
    val limit = 9_999_999
    val totients = totientsList(limit)
    var min = limit.toDouble()
    var minN = 0
    totients.forEachIndexed { index, i ->
        if ((0..1).contains(index) || !arePermutation(index, i)) return@forEachIndexed
        if (index / i.toDouble() < min) {
            min = index / i.toDouble()
            minN = index
        }
    }
    println(minN)
    kotlin.system.exitProcess(0)
}

fun arePermutation(a: Int, b: Int): Boolean = a.toString().toList().sorted() == b.toString().toList().sorted()