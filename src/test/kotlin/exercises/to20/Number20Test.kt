package exercises.to20

import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class Number20Test {
    @Test
    fun testSumOfDigits() {
        assertEquals(1, sumOfDigits(BigInteger.valueOf(1L)))
        assertEquals(1, sumOfDigits(BigInteger.valueOf(100L)))
        assertEquals(27, sumOfDigits(BigInteger.valueOf(3628800L)))
    }
}