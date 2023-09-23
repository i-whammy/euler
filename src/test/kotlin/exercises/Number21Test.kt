package exercises

import functions.getProperDivisorsOf
import kotlin.test.Test
import kotlin.test.assertEquals

class Number21Test {

    @Test
    fun testGetProperDivisorsOf() {
        assertEquals(listOf(), getProperDivisorsOf(1))
        assertEquals(listOf(1), getProperDivisorsOf(2))
        assertEquals(listOf(1,2,12,3,8,4,6), getProperDivisorsOf(24))
        assertEquals(listOf(1,5), getProperDivisorsOf(25))
        assertEquals(listOf(1,2,110,4,55,5,44,10,22,11,20), getProperDivisorsOf(220))
    }
}