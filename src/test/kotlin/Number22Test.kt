import exercises.calculateScore
import exercises.sumUpNamesScore
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals

class Number22Test {

    @Test
    fun testCalculateScore() {
        assertEquals(BigInteger.valueOf(49714), calculateScore("COLIN", 937))
    }

    @Test
    fun testSumUpNamesScore() {
        assertEquals(BigInteger.valueOf(54 + 53 * 2), sumUpNamesScore("\"COLIN\",\"ANNY\""))
    }
}