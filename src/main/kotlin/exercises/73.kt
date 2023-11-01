package exercises

fun main() {
    val count = relativePrimeCount(12_000, 1 / 2.toDouble(), 1 / 3.toDouble())
    println(count)
    kotlin.system.exitProcess(0)
}


fun relativePrimeCount(n: Int, upperLimit: Double, lowerLimit: Double): Int {
    val result = mutableListOf<MutableList<Int>>()
    var count = 0
    repeat(n + 1) {
        val numerators = (it/3..it/2).toMutableList()
        result.add(numerators)
    }
    for (i in 2..<result.size) {
        var tmpListIndex = i
        while (tmpListIndex <= n) {
            var tmpElement = i
            while (tmpElement <= tmpListIndex) {
                result[tmpListIndex].remove(tmpElement)
                tmpElement += i
            }
            tmpListIndex += i
        }
    }
    result.forEachIndexed { index, fractions ->
        fractions.forEach {
            val target = it / index.toDouble()
            if (target < upperLimit
                && lowerLimit < target
            ) {
                count++
            }
        }
    }
    return count
}