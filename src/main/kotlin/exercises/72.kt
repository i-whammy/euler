package exercises

import functions.totientsList

fun main() {
    val count = totientsList(1_000_000).drop(2).fold(0L) { acc, i -> acc + i.toLong() }
    println(count)
    kotlin.system.exitProcess(0)
}
