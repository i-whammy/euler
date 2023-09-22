package exercises

// https://projecteuler.net/problem=17

private val oneDigit = hashMapOf(1 to 3, 2 to 3, 3 to 5, 4 to 4, 5 to 4, 6 to 3, 7 to 5, 8 to 5, 9 to 4, 0 to 0)
private val tenDigitUnderTwenty =
    hashMapOf(10 to 3, 11 to 6, 12 to 6, 13 to 8, 14 to 8, 15 to 7, 16 to 7, 17 to 9, 18 to 8, 19 to 8)
private val tenDigitFromTwenty = hashMapOf(2 to 6, 3 to 6, 4 to 5, 5 to 5, 6 to 5, 7 to 7, 8 to 6, 9 to 6)
private const val hundred = 7
private const val and = 3
private const val thousand = 8

fun main() {
    println(countNumberLetters(1000))
}

fun countNumberLetters(below: Int): Int {
    return (0..below).reduce { acc, i ->
        acc + countNumber(i)
    }
}

fun countNumber(number: Int): Int {
    return when (digitOf(number)) {
        1 -> oneDigit[number]!!
        2 -> handleTwoDigitNumbers(number)
        3 -> handleThreeDigitNumbers(number)
        4 -> oneDigit[1]!! + thousand
        else -> 0
    }
}

fun handleTwoDigitNumbers(number: Int): Int {
    return if (number == 0) 0
    else if (number < 10) {
        oneDigit[number]!!
    } else if (number < 20) {
        tenDigitUnderTwenty[number]!!
    } else if (number % 10 == 0) {
        tenDigitFromTwenty[number / 10]!!
    } else tenDigitFromTwenty[number / 10]!! + oneDigit[number % 10]!!
}

fun handleThreeDigitNumbers(number: Int): Int {
    return if (number % 100 == 0) oneDigit[number / 100]!! + hundred
    else oneDigit[number / 100]!! + hundred + and + handleTwoDigitNumbers(number % 100)
}

fun digitOf(number: Int): Int {
    return if (number == 1000) 4
    else if (number >= 100) 3
    else if (number >= 10) 2
    else 1
}
