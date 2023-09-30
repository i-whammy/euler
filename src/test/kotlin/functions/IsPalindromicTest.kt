package functions

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsPalindromicTest {

    @Test
    fun testIsPalindromic() {
        assertTrue { isPalindromic(1) }
        assertTrue { isPalindromic(11) }
        assertFalse { isPalindromic(10) }
        assertTrue { isPalindromic(101) }
        assertTrue { isPalindromic(111) }
        assertFalse { isPalindromic(112) }
    }
}