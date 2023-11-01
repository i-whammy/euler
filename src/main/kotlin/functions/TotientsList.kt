package functions

fun totientsList(n: Int): List<Int> {
    val list = mutableListOf<Int>()
    repeat(n+1) { list.add(it) }
    for (i in 2..<list.size) {
        if (list[i] == i) {
            var tmp = i
            while (tmp <= n) {
                list[tmp] -= list[tmp] / i
                tmp += i
            }
        }
    }
    return list
}
