package exercises.to40

// https://projecteuler.net/problem=40

fun main() {
    // TODO: There may be smarter way
    println(solveWithBrutalWay())
    kotlin.system.exitProcess(0)
}

fun solveWithBrutalWay(): Int {
    val upperLimit = 1_000_000
    var fractionParts = ""
    var i = 1
    while (fractionParts.length < upperLimit) {
        fractionParts += i
        i++
    }
    return listOf(
        fractionParts[0],
        fractionParts[9],
        fractionParts[99],
        fractionParts[999],
        fractionParts[9999],
        fractionParts[99999],
        fractionParts[999999]
    )
        .map { it.digitToInt() }
        .reduce { acc, it -> acc * it }
}
