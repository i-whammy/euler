package exercises

// 1+1
// [2+1] 1+1+1
// 3+1 2+2 [2+1+1] 1+1+1+1
// 4+1 3+2 [3+1+1 2+2+1] [2+1+1+1] 1+1+1+1+1
// 5+1 4+2 3+3 [4+1+1 3+2+1 2+2+2] [3+1+1+1 2+2+1+1] [2+1+1+1+1] 1+1+1+1+1+1
// [6+1 5+2 4+3] [5+1+1 4+2+1 3+3+1 3+2+2] [4+1+1+1 3+2+1+1 2+2+2+1] [3+1+1+1+1 2+2+1+1+1] [2+1+1+1+1+1] 1+1+1+1+1+1+1
// [7+1 6+2 5+3 4+4] [6+1+1 5+2+1 4+3+1 4+2+2 3+3+2] [5+1+1+1 4+2+1+1 3+3+1+1 3+2+2+1 2+2+2+2]...

// f(n)
// elements ... 2 -> n
// n-elements way ... 1
// n-1-elements way ... 1
// n-2-elements way ... 2
// n-3-elements way ...
// ...
// 2-elements way ... n/2


fun main() {
    println(fillOutSums(5).takeLast(2).first().sum())
    kotlin.system.exitProcess(0)
}

fun fillOutSums(n: Int): List<List<Int>> {
    val list = mutableListOf<List<Int>>()
    (0..n).forEach { a ->
        val ways = mutableListOf<Int>()
        (n downTo 0).forEach { b ->
            println("a = $a b = $b")
            if (b == a) {
                ways.add(1)
            } else if (b > a) ways.add(0)
            else if (b == 0) ways.add(ways.last())
            else ways.add(ways.last() + list[a - b][b])
        }
        list.add(ways)
    }
    println(list)
    return list
}