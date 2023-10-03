package functions

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsPandigitalTest {

    @Test
    fun testIsPandigital() {
        assertTrue { isPandigital(12L, false) }
        assertFalse { isPandigital(23L, false) }
        assertTrue { isPandigital(213L, false) }
        assertFalse { isPandigital(11L, false) }

        assertTrue { isPandigital(120L, true) }
        assertFalse { isPandigital(120L, false) }
        assertFalse { isPandigital(123L, true) }
        assertFalse { isPandigital(112L, true) }
    }
}