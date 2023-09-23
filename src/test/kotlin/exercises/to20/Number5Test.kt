package exercises.to20

import kotlin.test.Test
import kotlin.test.assertEquals

class Number5Test {
    @Test
    fun getMaxMultipleUntil() {
        assertEquals(16, getMaxMultipleUntil(2, 20))
        assertEquals(8, getMaxMultipleUntil(2, 10))
    }
}