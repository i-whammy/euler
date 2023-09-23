package exercises.to20

import kotlin.test.Test
import kotlin.test.assertEquals

class Number17Test {

    @Test
    fun `handle 2 digits`() {
        assertEquals(3, handleTwoDigitNumbers(10))
        assertEquals(9, handleTwoDigitNumbers(21))
        assertEquals(10, handleTwoDigitNumbers(99))
        assertEquals(8, handleTwoDigitNumbers(51))
    }

    @Test
    fun `handle 3 digits`() {
        assertEquals(10, handleThreeDigitNumbers(100))
        assertEquals(23, handleThreeDigitNumbers(351))
        assertEquals(20, handleThreeDigitNumbers(703))
    }

    @Test
    fun `handle thousand`() {
        assertEquals(11, countNumber(1000))
    }
}