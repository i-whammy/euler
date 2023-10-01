package exercises

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Number32Test {

    @Test
    fun testIsPandigitalProduct() {
        assertTrue { isPandigitalProduct(39,186) }
        assertFalse { isPandigitalProduct(15, 234) }
    }
}