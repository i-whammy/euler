// https://projecteuler.net/problem=1

fun main() {
    val target = (1..999).toList()
    println(calc(target))
}

fun calc(numbers: List<Int>): Int {
    return numbers.filter { it % 3 == 0 || it % 5 == 0 }
        .reduce { acc, i -> acc + i }
}