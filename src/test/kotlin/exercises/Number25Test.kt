package exercises

import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class Number25Test {

    @Test
    fun testFibonacci() {
        assertEquals(BigInteger.ONE, fibonacci(1))
        assertEquals(BigInteger.ONE, fibonacci(2))
        assertEquals(BigInteger.TWO, fibonacci(3))
        assertEquals(BigInteger.valueOf(13), fibonacci(7))
        assertEquals(BigInteger.valueOf(144), fibonacci(12))
    }
}