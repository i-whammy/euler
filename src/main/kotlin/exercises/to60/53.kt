package exercises.to60

import functions.optimizedFactory
import java.math.BigInteger

fun main() {
    val answer = (1..100)
        .flatMap { a -> (1..a).map { b -> combinationsOf(a, b) } }
        .filter { it > BigInteger.valueOf(1_000_000) }.size
    println(answer)
    kotlin.system.exitProcess(0)
}

// nCr = n! / (n-r)!r! = nPr / r!
fun combinationsOf(n: Int, r: Int): BigInteger {
    val permutations = permutationsOf(n, r)
    return permutations / optimizedFactory(r)
}

// nPr = n! / r!
fun permutationsOf(n: Int, r: Int): BigInteger {
    return optimizedFactory(n) / optimizedFactory((n - r))
}