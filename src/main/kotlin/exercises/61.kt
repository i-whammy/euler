package exercises

private val triangles = (1..140).map { it * (it + 1) / 2 }.filter { it in 1000..9999 }
private val squares = (1..140).map { it * it }.filter { it in 1000..9999 }
private val pentagonals = (1..140).map { it * (it * 3 - 1) / 2 }.filter { it in 1000..9999 }
private val hexagonals = (1..140).map { it * (it * 2 - 1) }.filter { it in 1000..9999 }
private val heptagonals = (1..140).map { it * (it * 5 - 3) / 2 }.filter { it in 1000..9999 }
private val octagonals = (1..140).map { it * (it * 3 - 2) }.filter { it in 1000..9999 }

fun main() {
    println(getCyclicDigits(6).sum())
    kotlin.system.exitProcess(0)
}

fun getCyclicDigits(
    amount: Int,
    polygonals: List<List<Int>> = mutableListOf(
        triangles,
        squares,
        pentagonals,
        hexagonals,
        heptagonals,
        octagonals
    ).subList(0, amount),
    candidates: MutableList<Int> = mutableListOf()
): List<Int> {
    var result = listOf<Int>()
    when (candidates.size) {
        0 ->
            polygonals.first().forEach { a1 ->
                val remainings = polygonals.toMutableList()
                remainings.remove(polygonals.first())
                val c = mutableListOf<Int>()
                c.add(a1)
                getCyclicDigits(amount, remainings, c).takeIf { it.isNotEmpty() }?.let { result = it } ?: return@forEach
            }

        amount - 1 -> {
            return cyclesOf(candidates.last())
                .filter { cycleNumber ->
                    polygonals.last().contains(cycleNumber)
                }.filter { f1 -> cyclesOf(f1).contains(candidates.first()) }
                .takeIf { it.isNotEmpty() }?.let {
                    val c = mutableListOf<Int>()
                    c.addAll(candidates)
                    c.add(it.first())
                    println(c)
                    c
                } ?: emptyList()
        }

        else -> {
            val cycleBase = candidates.last()
            cyclesOf(cycleBase).forEach { cycleNumber ->
                val remainings = polygonals.toMutableList()
                remainings.filter { it.contains(cycleNumber) }
                    .forEach label@{ p ->
                        remainings.remove(p)
                        val c = mutableListOf<Int>()
                        c.addAll(candidates)
                        c.add(cycleNumber)
                        getCyclicDigits(amount, remainings, c).takeIf { it.isNotEmpty() }?.let { result = it }
                            ?: return@label
                    }
            }
        }
    }
    return result
}

fun cyclesOf(n: Int): List<Int> = (0..99).map { it + n % 100 * 100 }