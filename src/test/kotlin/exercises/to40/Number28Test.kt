package exercises.to40

import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class Number28Test {

    @Test
    fun testSumDiagonalsInSpiral() {
        assertEquals(BigInteger.valueOf(25), sumDiagonalsInSpiral(3))
        assertEquals(BigInteger.valueOf(101), sumDiagonalsInSpiral(5))
    }
}