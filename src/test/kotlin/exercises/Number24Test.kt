package exercises

import kotlin.test.Test
import kotlin.test.assertEquals

class Number24Test {

    @Test
    fun testGetLexicographicPermutations() {
        assertEquals("102", getLexicographicPermutations("012", 3))
        assertEquals("2103", getLexicographicPermutations("0123", 15))
    }
}