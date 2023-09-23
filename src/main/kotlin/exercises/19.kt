package exercises

// https://projecteuler.net/problem=19

private val daysOfMonths = arrayOf(31,28,31,30,31,30,31,31,30,31,30,31)

fun main() {
    println(countFirstDateSunday())
}

fun countFirstDateSunday(): Int {
    var sundays = 0
    var year = 1901
    var day = 366 % 7 // Set day of 1st Jan 1901

    while (year <= 2000) {
        daysOfMonths.forEachIndexed { i, daysOfMonth ->
            if (day == 0) sundays++
            if (i == 1 && year.isLeapYear()) day += 1
            day = (day + daysOfMonth) % 7
        }
        year++
    }

    return sundays
}

fun Int.isLeapYear() : Boolean {
    return if (this % 100 == 0) this % 400 == 0
    else this % 4 == 0
}