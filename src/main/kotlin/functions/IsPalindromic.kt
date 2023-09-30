package functions

import java.math.BigInteger

fun isPalindromic(number: Int): Boolean {
    return isPalindromic(number.toBigInteger())
}

fun isPalindromic(number: Long): Boolean {
    return isPalindromic(number.toBigInteger())
}

fun isPalindromic(number: BigInteger): Boolean {
    val numberCharArray = number.toString().toCharArray()
    val digitsNumber = numberCharArray.size
    return (0..<digitsNumber/2).all { i -> numberCharArray[i] == numberCharArray[digitsNumber-i-1] }
}