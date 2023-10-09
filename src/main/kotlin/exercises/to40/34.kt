package exercises.to40

private val factorials = arrayOf(
    1,
    1,
    2,
    6,
    24,
    120,
    720,
    5040,
    40320,
    362880)

fun main() {
    val answers = (3..10_000_000).filter { it == digitsToFactorialSum(it) }
    println(answers.sum())
    kotlin.system.exitProcess(0)
}

fun digitsToFactorialSum(number: Int): Int {
    return number.toString().map { factorials[it.digitToInt()] }.sumOf { it }
}