package exercises

// https://projecteuler.net/problem=22

import java.io.File
import java.math.BigInteger
import kotlin.system.exitProcess

private const val alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

fun main() {
    val names = File("src/main/resources/0022_names.txt").inputStream().readBytes().toString(Charsets.UTF_8)
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