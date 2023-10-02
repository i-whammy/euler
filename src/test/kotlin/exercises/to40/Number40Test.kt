package exercises.to40

import kotlin.test.Test
import kotlin.test.assertEquals

class Number40Test {

    @Test
    fun testFindNthDigitPositiveInteger() {
        assertEquals(1, findNthDigitPositiveInteger(1))
        assertEquals(2, findNthDigitPositiveInteger(2))
        assertEquals(11, findNthDigitPositiveInteger(13))
        assertEquals(12, findNthDigitPositiveInteger(14))
        assertEquals(101, findNthDigitPositiveInteger(195))
        assertEquals(102, findNthDigitPositiveInteger(196))
        assertEquals(102, findNthDigitPositiveInteger(197))
    }

    @Test
    fun testMaximumDigitsIndex() {
        assertEquals(0, maximumDigitsIndex(0))
        assertEquals(9, maximumDigitsIndex(1))
        assertEquals(189, maximumDigitsIndex(2))
        assertEquals(2889, maximumDigitsIndex(3))
    }

    @Test
    fun findNthRemainder() {
        assertEquals(0, findNthRemainder(10))
        assertEquals(1, findNthRemainder(11))
        assertEquals(0, findNthRemainder(12))
        assertEquals(0, findNthRemainder(100))
        assertEquals(2, findNthRemainder(2889))
        assertEquals(0, findNthRemainder(2890))
    }

    @Test
    fun findNthNumber() {
        assertEquals(1, findNthNumber(1))
        assertEquals(1, findNthNumber(10))
        assertEquals(0, findNthNumber(11))
        assertEquals(1, findNthNumber(12))
        assertEquals(1, findNthNumber(13))
    }
}