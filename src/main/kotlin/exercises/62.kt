package exercises

import java.math.BigInteger

fun main() {
    val cubeMap = (1..10000L).map { BigInteger.valueOf(it).pow(3) }.groupBy { it.toString().length }
    val permutationsCount = 5
    val min = cubeMap.entries.flatMap { entry ->
        val (digit, cubes) = entry
        cubes.map { cube ->
            cubeMap[digit]?.filter { cube.isPermutationOf(it) }?.takeIf { it.size == permutationsCount }?.let { cube } ?: BigInteger.ZERO
        }
    }.filter { it != BigInteger.ZERO }.min()
    println(min)
    kotlin.system.exitProcess(0)
}

fun BigInteger.isPermutationOf(a: BigInteger): Boolean {
    return this.toString().toList().sorted() == a.toString().toList().sorted()
}