package functions

fun isPandigital(a: Long, includesZero: Boolean = false): Boolean {
    val set = a.toString().toSet()
    return if (includesZero) set.size == a.toString().length
    else set.size == a.toString().length
            && !set.contains('0')
}