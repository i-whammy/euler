package exercises

fun main() {
    println(findExactSameDigits(100000L, 6))
    kotlin.system.exitProcess(0)
}

fun findExactSameDigits(from: Long, multiply: Int): Long {
    var current = from
    while (true) {
        val numbers = (1..multiply).map { current * it }
        if (containsExactlySameDigits(numbers)) return current
        current++
    }
}

fun containsExactlySameDigits(numbers: List<Long>): Boolean {
    val mutableNumbers = numbers.toMutableList()
    return mutableNumbers.map { it.toString().toCharArray().sorted() }.toSet().size == 1
}