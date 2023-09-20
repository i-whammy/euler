package functions

import kotlin.test.Test
import kotlin.test.assertEquals

class IsPrimeTest {
    @Test
    fun isPrimeTest() {
        assertEquals(true, isPrime(7))
        assertEquals(false, isPrime(25))
        assertEquals(false, isPrime(14))
        assertEquals(false, isPrime(4))
        assertEquals(false, isPrime(1))
    }

}