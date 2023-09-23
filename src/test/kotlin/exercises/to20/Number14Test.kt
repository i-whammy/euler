package exercises.to20

import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class Number14Test {

    @Test
    fun getChainCountOfTest() {
        assertEquals(BigInteger.ONE, getChainCountOf(1))
        assertEquals(BigInteger.TWO, getChainCountOf(2))
        assertEquals(BigInteger.valueOf(3), getChainCountOf(4))
        assertEquals(BigInteger.valueOf(5), getChainCountOf(16))
        assertEquals(BigInteger.valueOf(6), getChainCountOf(5))
        assertEquals(BigInteger.valueOf(10), getChainCountOf(13))
    }
}