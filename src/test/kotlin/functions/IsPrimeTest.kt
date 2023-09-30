package functions

import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class IsPrimeTest {
    @Test
    fun isPrimeTest() {
        assertEquals(true, isPrime(BigInteger.valueOf(7)))
        assertEquals(false, isPrime(BigInteger.valueOf(25)))
        assertEquals(false, isPrime(BigInteger.valueOf(14)))
        assertEquals(false, isPrime(BigInteger.valueOf(4)))
        assertEquals(false, isPrime(BigInteger.valueOf(1)))
    }

}