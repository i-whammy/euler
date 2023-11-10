package exercises.to40

// https://projecteuler.net/problem=22

import functions.readFile
import java.math.BigInteger
import kotlin.io.path.Path
import kotlin.system.exitProcess

private const val alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

fun main() {
    val names = readFile(Path("src/main/resources/0022_names.txt"))
    println(sumUpNamesScore(names))
    exitProcess(0)
}

fun sumUpNamesScore(names: String): BigInteger {
    return names.split(",")
        .map { it.replace("\"", "") }
        .sortedBy { it }
        .mapIndexed { index, s -> calculateScore(s, index) }
        .reduce { acc, i -> acc + i }
}

fun calculateScore(name: String, index: Int): BigInteger {
    return name.map { ((alphabets.indexOf(it) + 1) * (index + 1)).toBigInteger() }.reduce { acc, i -> acc + i }
}