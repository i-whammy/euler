package exercises

import java.io.File
import kotlin.math.max

fun main() {
    val triangleList = File("src/main/resources/0067_triangle.txt").readBytes().toString(Charsets.UTF_8).toIntegerTriangleList()
    val maximumList = triangleList.map { it.toMutableList() }.toMutableList()
    (triangleList.size-2 downTo 0).forEach { i ->
        (triangleList[i].size-1 downTo 0).forEachIndexed { j, _ ->
            maximumList[i][j] += max(maximumList[i+1][j], maximumList[i+1][j+1])
        }
    }
    println(maximumList[0][0])
    kotlin.system.exitProcess(0)
}

private fun String.toIntegerTriangleList(): List<List<Int>> = this
    .split("\n")
    .filter { it.isNotEmpty() }
    .map { it.split(" ").map { s -> s.toInt() } }
