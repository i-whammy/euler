package exercises.unsolved

import functions.pentagonal
import functions.pentagonals

// pentagonal = (n.pow(2) * 3 - n) / 2
// Pj + Pk = pentagonal
// Pj - Pk = pentagonal
// j != k (as Pj - Pj = 0, 0 is not pentagonal)
fun main() {
    val pentagonals = pentagonals(3000)
    val doublePentagonal = permutations(3000)
        .first { p ->
            isPentagonal(pentagonals[p.first - 1] + pentagonals[p.second - 1])
                    &&
                    isPentagonal(pentagonals[p.second - 1] - pentagonals[p.first - 1])
        }
    println(pentagonal(doublePentagonal.second) - pentagonal(doublePentagonal.first))
    println(doublePentagonal)
    kotlin.system.exitProcess(0)
}

fun permutations(n: Int): List<Pair<Int, Int>> {
    return (1..n).flatMap { a ->
        (a + 1..n).map { b -> a to b }
    }
}

fun isPentagonal(n: Long): Boolean {
    when (n) {
        1L -> return true
        else -> {
            var sum = 1L
            var i = 1
            while (sum < n) {
                sum += 3 * i + 1
                if (sum == n) return true
                i++
            }
            return false
        }
    }
}