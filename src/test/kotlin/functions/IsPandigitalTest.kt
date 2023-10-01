package functions

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsPandigitalTest {

    @Test
    fun testIsPandigital() {
        assertTrue { isPandigital(23L, false) }
        assertFalse { isPandigital(11L, false) }

        assertTrue { isPandigital(10L, true) }
        assertFalse { isPandigital(10L, false) }
        assertTrue { isPandigital(23L, true) }
        assertFalse { isPandigital(11L, true) }
    }
}