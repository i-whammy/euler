package exercises

import exercises.unsolved.getFractionRecurringCycle
import kotlin.test.Test
import kotlin.test.assertEquals

class Number26Test {

    @Test
    fun testFractionDenominatorCycle() {
        assertEquals(0, getFractionRecurringCycle(1))
        assertEquals(0, getFractionRecurringCycle(2))
        assertEquals(1, getFractionRecurringCycle(3))
        assertEquals(1, getFractionRecurringCycle(6))
        assertEquals(6, getFractionRecurringCycle(7))
    }
}