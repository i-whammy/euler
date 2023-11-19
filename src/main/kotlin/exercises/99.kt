package exercises

import functions.readFile
import kotlin.io.path.Path
import kotlin.math.log10

fun main() {
    val lines = readFile(Path("src/main/resources/0099_base_exp.txt"))
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { str -> str.split(",")
            .let { it.first().toDouble() to it.last().toInt() } }
    val max = lines.mapIndexed { index, it -> index to log10(it.first) * it.second }.maxBy { it.second }
    println(max.first + 1)
    kotlin.system.exitProcess(0)
}