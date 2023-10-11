package exercises

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Number44Test {

    @Test
    fun testIsPentagonal() {
        assertTrue { isPentagonal(1) }
        assertFalse { isPentagonal(2) }
        assertFalse { isPentagonal(3) }
        assertFalse { isPentagonal(4) }
        assertTrue { isPentagonal(5) }
        assertFalse { isPentagonal(6) }
        assertFalse { isPentagonal(7) }
        assertFalse { isPentagonal(8) }
        assertFalse { isPentagonal(9) }
        assertFalse { isPentagonal(10) }
        assertFalse { isPentagonal(11) }
        assertTrue { isPentagonal(12) }
        assertTrue { isPentagonal(51) }
        assertTrue { isPentagonal(70) }
    }
}