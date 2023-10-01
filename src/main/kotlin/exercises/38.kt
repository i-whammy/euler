package exercises

// https://projecteuler.net/problem=38

import functions.isPandigital

// Because the example already shows that 918273645 is 1 to 9 pandigital 9-digit number,
// the answer should be more than that.
// Moreover, the first digit(one-millions place) is the first digit of the answer(N) because this comes from the product of N * 1 = N.
// Therefore, the answer should be the integer which starts from 9.
// The condition is n > 1, so the upper limit of N is 9999 becaues the total digits must be 9-digit number and must not be more than 10 digits.
fun main() {
    val targets = (9..9999).filter { it.toString()[0] == '9' }
    var answer = 0L
    targets.forEach {
        var n = ""
        var index = 1
        while (n.length < 9) {
            n += it * index
            index++
        }
        val candidate = n.toLong()
        if (isPandigital(candidate) && answer < candidate) answer = candidate
    }
    println(answer)
    kotlin.system.exitProcess(0)
}