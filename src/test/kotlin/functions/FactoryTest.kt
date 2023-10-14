package functions

import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class FactoryTest {
    @Test
    fun testFactory() {
        assertEquals(BigInteger.ONE, factory(1))
        assertEquals(BigInteger.ONE, factory(1))
        assertEquals(BigInteger.valueOf(6L), factory(3))
        assertEquals(BigInteger.valueOf(3628800L), factory(10))
    }
}