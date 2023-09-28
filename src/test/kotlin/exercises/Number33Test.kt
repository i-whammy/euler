package exercises

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Number33Test {

    @Test
    fun testGetDigitallyFriendsNumbers() {
        assertEquals(
            listOf(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,31,32,41,42,51,52,61,62,71,72,81,82,91,92), getDigitallyFriendsNumbers(12))
    }

    @Test
    fun testIsDigitCancellingFraction() {
        assertTrue { isDigitCancellingFraction(10, 20) }
        assertTrue { isDigitCancellingFraction(49, 98) }
        assertFalse { isDigitCancellingFraction(22, 22) }
        assertFalse { isDigitCancellingFraction(32, 53) }
    }
}