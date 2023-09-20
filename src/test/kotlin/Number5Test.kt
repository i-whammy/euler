import kotlin.test.Test
import kotlin.test.assertEquals

class Number5Test {

    @Test
    fun isPrimeTest() {
        assertEquals(true, isPrime(7))
        assertEquals(false, isPrime(25))
        assertEquals(false, isPrime(14))
        assertEquals(false, isPrime(4))
        assertEquals(false, isPrime(1))
    }

    @Test
    fun getMaxMultipleUntil() {
        assertEquals(16, getMaxMultipleUntil(2, 20))
        assertEquals(8, getMaxMultipleUntil(2, 10))
    }
}