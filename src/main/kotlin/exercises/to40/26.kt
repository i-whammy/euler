package exercises.to40

fun main() {
    println((2..999).maxBy { getFractionRecurringCycle(it) })
    kotlin.system.exitProcess(0)
}

fun getFractionRecurringCycle(denominator: Int): Int {
    val currentDigits = mutableMapOf<Int, Int>()
    var counter = 0
    var current = 1
    while (true) {
        if (currentDigits.contains(current)) {
            return counter - currentDigits[current]!!
        }
        currentDigits[current] = counter
        current = current * 10 % denominator
        counter++
    }
}