package exercises

fun main() {
    var count = 0
    (1..10_000_000).forEach { i ->
        var number = i
        var count1 = 0
        var count89 = 0
        while (count1 < 2 && count89 < 2) {
            val sum = number.toString().map { n -> n.digitToInt() * n.digitToInt() }.reduce { acc, it -> acc + it }
            if (sum == 1) count1++
            else if (sum == 89) count89++
            if (count89 == 2) count++
            number = sum
        }
    }
    println(count)
    kotlin.system.exitProcess(0)
}
