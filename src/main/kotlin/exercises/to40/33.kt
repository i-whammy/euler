package exercises.to40

// https://projecteuler.net/problem=33

fun main() {
    println(getDigitCancellingFractions())
    kotlin.system.exitProcess(0)
}

fun getDigitCancellingFractions(): Map<Int, List<Int>> {
    return (10..99).map { numerator ->
        getDigitallyFriendsNumbers(numerator)
            .filter { denominator ->
                isDigitCancellingFraction(numerator, denominator)
                        && isNonTrivial(numerator, denominator)
            }.groupBy { numerator }
    }.filter { it.isNotEmpty() }.reduce { acc, map -> acc.plus(map) }
}

// In this context, when two numbers, A and B are "digitally friends", it means either
// 1. tens place of A == tens place of B or
// 2. ones place of A == ones place of B or
// 3. tens place of A == ones place of B or
// 4. ones place of A == tens place of B
fun getDigitallyFriendsNumbers(number: Int): List<Int> {
    return (10..99)
        .filter { areDigitallyFriends(number, it) }
}

fun isDigitCancellingFraction(numerator: Int, denominator: Int): Boolean {
    val original = numerator / denominator.toDouble()
    val n = numerator.toString().firstOrNull { !denominator.toString().contains(it) }?.digitToInt() ?: return false
    val d = denominator.toString().firstOrNull { !numerator.toString().contains(it) }?.digitToInt() ?: return false
    return original == n / d.toDouble() && n / d < 1
}

fun isNonTrivial(numerator: Int, denominator: Int): Boolean {
    return !numerator.toString().contains("0")
            && !denominator.toString().contains("0")
}

private fun areDigitallyFriends(a: Int, b: Int) =
    a % 10 == b % 10
            || a / 10 == b / 10
            || a / 10 == b % 10
            || a % 10 == b / 10