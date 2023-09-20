// https://projecteuler.net/problem=2

fun main() {
    println(evenFibonacciNumbers())
}

fun evenFibonacciNumbers(): Int {
    val limit = 4_000_000
    val evens = mutableListOf(2)
    var a = 1
    var b = 2
    var c = a + b
    while (c < limit) {
        if (c % 2 == 0) evens.add(c)
        a = b
        b = c
        c = a + b
    }
    return evens.reduce { acc, i -> acc + i }
}
