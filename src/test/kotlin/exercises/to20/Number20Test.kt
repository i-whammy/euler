package exercises.to20

import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class Number20Test {

    @Test
    fun testFactory() {
        assertEquals(BigInteger.ONE, factory(1))
        assertEquals(BigInteger.valueOf(6L), factory(3))
        assertEquals(BigInteger.valueOf(3628800L), factory(10))
    }

    @Test
    fun testSumOfDigits() {
        assertEquals(1, sumOfDigits(BigInteger.valueOf(1L)))
        assertEquals(1, sumOfDigits(BigInteger.valueOf(100L)))
        assertEquals(27, sumOfDigits(BigInteger.valueOf(3628800L)))
    }
}