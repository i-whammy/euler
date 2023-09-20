// https://projecteuler.net/problem=4

fun main() {
    println(largestPalindromeProduct())
}

fun largestPalindromeProduct(): Int {
    var a = 100
    var b = 100
    var max = 0
    while (a < 1000) {
        while (b < 1000) {
            if (isPalindrome(a * b) && max < a * b) {
                max = a * b
            }
            b += 1
        }
        a += 1
        b = 100
    }
    return max
}

fun isPalindrome(number: Int): Boolean {
    val numberCharArray = number.toString().toCharArray()
    return if (numberCharArray.size % 2 == 0) {
        println(number)
        numberCharArray[0] == numberCharArray[5] && numberCharArray[1] == numberCharArray[4] && numberCharArray[2] == numberCharArray[3]
    } else {
        numberCharArray[0] == numberCharArray[4] && numberCharArray[1] == numberCharArray[3]
    }
}