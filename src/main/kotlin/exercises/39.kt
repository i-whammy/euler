package exercises

import kotlin.math.pow

// https://projecteuler.net/problem=39


// condition of triangle
// when a <= b <= c, and a + b + c = p
// 1. a + b > c;
// -> a + b + c > 2c
// -> p > 2c
// -> c < p / 2;
// 2. a > c - b;
// -> 2a + 2b > a + b + c
// -> a + b > p / 2
fun main() {
    val maxPerimeterPatternsP = (3..1000)
        .map {
            generateTriangleLengthSides(it)
                .filter { triangle -> triangle.isRightAngleTriangle() }
        }
        .filter { it.isNotEmpty() }
        .maxBy { it.count() }
        .first().perimeter
    println(maxPerimeterPatternsP)
    kotlin.system.exitProcess(0)
}

fun generateTriangleLengthSides(p: Int): List<Triangle> {
    val triangles = mutableListOf<Triangle>()
    var c = if (p % 2 == 0) p / 2 - 1 else p / 2
    var b = c
    while (b <= c) {
        b = c
        var a = p - (b + c)
        while (a <= b) {
            triangles.add(Triangle(a, b, c))
            a++
            b--
        }
        c--
    }
    return triangles
}

data class Triangle(val a: Int, val b: Int, val c: Int) {
    val perimeter = a + b + c

    fun isRightAngleTriangle(): Boolean {
        return a.toDouble().pow(2) + b.toDouble().pow(2) == c.toDouble().pow(2)
    }
}

