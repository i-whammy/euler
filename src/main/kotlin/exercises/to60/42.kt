package exercises.to60

import functions.readFile
import kotlin.io.path.Path
import kotlin.math.sqrt

private const val alphabets = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ"

fun main() {
    val wordValues = readFile(Path("src/main/resources/0042_words.txt"))
        .replace("\"", "").split(",").fold(hashMapOf<String, Int>()) { acc, s ->
            acc[s] = calculateWordValue(s)
            acc
        }
    println(wordValues.filter { isTriangleNumber(it.value) }.count())
    kotlin.system.exitProcess(0)
}

fun calculateWordValue(word: String): Int {
    return word.map { alphabets.indexOf(it) }.sum()
}

fun isTriangleNumber(n: Int): Boolean {
    val upperLimit = sqrt(n.toDouble() * 2).toInt()
    return (1..upperLimit).any { n == it * (it + 1) / 2 }
}