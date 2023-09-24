package exercises

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Number23Test {

    @Test
    fun testIsAbundant() {
        assertFalse { 1.isAbundant() }
        assertTrue { 12.isAbundant() }
        assertFalse { 28.isAbundant() }
    }
}