package exercises.to40

import kotlin.test.Test
import kotlin.test.assertEquals

class Number39Test {

    @Test
    fun testGenerateTriangleLengthSides() {
        assertEquals(listOf(
            Triangle(1,3,3),
            Triangle(2,2,3)
        ), generateTriangleLengthSides(7)
        )
        assertEquals(listOf(
            Triangle(2,3,3),
        ), generateTriangleLengthSides(8)
        )
        assertEquals(listOf(
            Triangle(1,4,4),
            Triangle(2,3,4),
            Triangle(3,3,3),
        ), generateTriangleLengthSides(9)
        )
        assertEquals(listOf(
            Triangle(2,4,4),
            Triangle(3,3,4),
        ), generateTriangleLengthSides(10)
        )
    }
}