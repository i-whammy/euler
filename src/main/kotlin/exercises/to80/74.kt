package exercises.to80

private val factors = listOf(1,1,2,6,24,120,720,5040,40320,362880)

fun main() {
    val count = (1..1_000_000).count { countLoop(it) == 60 }
    println(count)
//    (1..10).forEach { println(countLoop(it)) }

    kotlin.system.exitProcess(0)
}

fun countLoop(n: Int): Int {
    val existings = mutableListOf(n)
    var current = n
    while (true) {
        val sum = numberToDigitFactorials(current)
        if (existings.contains(sum)) {
            return existings.size
        }
        existings.add(sum)
        current = sum
    }
}

fun numberToDigitFactorials(n: Int): Int {
    val str = n.toString()
    return str.fold(0) { sum, c -> sum + factors[c.digitToInt()] }
}