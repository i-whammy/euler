package functions

fun isPandigital(a: Long, includesZero: Boolean = false): Boolean {
    val digit = a.toString().length
    val pandigitalSet = if (includesZero) (0L..<digit).toSet() else (1L..digit).toSet()
    val set = a.toString().map { it.digitToInt().toLong() }.toSet()
    return pandigitalSet == set
}