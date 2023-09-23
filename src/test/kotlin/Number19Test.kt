import exercises.isLeapYear
import kotlin.test.Test
import kotlin.test.assertEquals

class Number19Test {

    @Test
    fun testIsLeapYear() {
        assertEquals(false, 1901.isLeapYear())
        assertEquals(true, 1904.isLeapYear())
        assertEquals(false, 1900.isLeapYear())
        assertEquals(false, 1800.isLeapYear())
        assertEquals(false, 2100.isLeapYear())
        assertEquals(true, 2000.isLeapYear())
    }
}