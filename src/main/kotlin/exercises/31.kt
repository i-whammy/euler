package exercises

// https://projecteuler.net/problem=31

fun main() {
    val start = System.currentTimeMillis()
    val count = func1()
    println("Current time ${System.currentTimeMillis() - start}ms")
    println(count)
    kotlin.system.exitProcess(0)
}

fun func1(): Int {
    var count = 0
    (200 downTo 0)
        .map { a ->
            ((200 - a * 200) downTo 0)
                .map { b -> ((200 - a * 200 - b * 100) downTo 0)
                    .map { c -> ((200 - a * 200 - b * 100 - c * 50) downTo 0)
                        .map { d -> ((200 - a * 200 - b * 100 - c * 50 - d * 20) downTo 0)
                            .map { e -> ((200 - a * 200 - b * 100 - c * 50 - d * 20 - e * 10) downTo 0)
                                .map { f -> ((200 - a * 200 - b * 100 - c * 50 - d * 20 - e * 10 - f * 5) downTo 0)
                                    .map { g -> ((200 - a * 200 - b * 100 - c * 50 - d * 20 - e * 10 - f * 5 - g * 2) downTo 0)
                                        .filter { h -> a * 200 + b * 100 + c * 50 + d * 20 + e * 10 + f * 5 + g * 2 + h == 200 }.forEach { count++ }}}
                            }
                        }}}}
    return count
}
