package exercises

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Number35Test {

    @Test
    fun testIsCircularPrime() {
        assertTrue { 13.isCircularPrime() }
        assertTrue { 971.isCircularPrime() }
        assertTrue { 2.isCircularPrime() }
        assertFalse { 144.isCircularPrime() }
        assertFalse { 1.isCircularPrime() }
    }
}