package exercises

private val triangles = (1..140).map { it * (it + 1) / 2 }.filter { it in 1000..9999 }
private val squares = (1..140).map { it * it }.filter { it in 1000..9999 }
private val pentagonals = (1..140).map { it * (it * 3 - 1) / 2 }.filter { it in 1000..9999 }
private val hexagonals = (1..140).map { it * (it * 2 - 1) }.filter { it in 1000..9999 }
private val heptagonals = (1..140).map { it * (it * 5 - 3) / 2 }.filter { it in 1000..9999 }
private val octagonals = (1..140).map { it * (it * 3 - 2) }.filter { it in 1000..9999 }

fun main() {
//    octagonals.forEach { a ->
//        (0..99).map { it + a % 100 * 100 }.filter { heptagonals.contains(it) }
//            .forEach { b ->
//                (0..99).map { it + b % 100 * 100 }.filter { hexagonals.contains(it) }
//                    .forEach { c ->
//                        (0..99).map { it + c % 100 * 100 }.filter { pentagonals.contains(it) }
//                            .forEach { d ->
//                                (0..99).map { it + d % 100 * 100 }.filter { squares.contains(it) }
//                                    .forEach { e ->
//                                        (0..99).map { it + e % 100 * 100 }.filter { triangles.contains(it) }
//                                            .forEach { f ->
//                                                println("$a $b $c $d $e $f")
//                                            }
//                                    }
//                            }
//                    }
//            }
//    }
    println(getCyclicDigits(6).sum())
    kotlin.system.exitProcess(0)
}

fun getCyclicDigits(
    amount: Int,
    polygonals: List<List<Int>> = mutableListOf(
        squares,
        pentagonals,
        hexagonals,
        heptagonals,
        octagonals
    )
        .subList(0, amount - 1).toList(),
): List<Int> {
    // TODO standardize
    triangles.forEach { a1 ->
        cyclesOf(a1).filter { ac1 ->
            polygonals.any { polygonal -> polygonal.contains(ac1) }
        }.forEach { b1 ->
            val remainings = polygonals.toMutableList()
            remainings.filter { polygonal -> polygonal.contains(b1) }
                .forEach { p ->
                    remainings.remove(p)
                    cyclesOf(b1).filter { bc1 -> remainings.any { polygonal -> polygonal.contains(bc1) } }
                        .forEach { c1 ->
                            val remainings2 = remainings.toMutableList()
                            remainings2.filter { polygonal -> polygonal.contains(c1) }
                                .forEach { p ->
                                    remainings2.remove(p)
                                    cyclesOf(c1).filter { cc1 -> remainings2.any { polygonal -> polygonal.contains(cc1) } }
                                        .forEach { d1 ->
                                            val remainings3 = remainings2.toMutableList()
                                            remainings3.filter { polygonal -> polygonal.contains(d1) }
                                                .forEach { p ->
                                                    remainings3.remove(p)
                                                    cyclesOf(d1).filter { dc1 -> remainings3.any { polygonal -> polygonal.contains(dc1) } }
                                                        .forEach { e1 ->
                                                            val remainings4 = remainings3.toMutableList()
                                                            remainings4.filter { polygonal -> polygonal.contains(e1) }
                                                                .forEach { p ->
                                                                    remainings4.remove(p)
                                                                    cyclesOf(e1).filter { ec1 -> remainings4.any { polygonal -> polygonal.contains(ec1) } }
                                                                        .forEach { f1 ->
                                                                            if (cyclesOf(f1).contains(a1)) {
                                                                                val list = listOf(a1,b1,c1,d1,e1,f1)
                                                                                println(list)
                                                                                return list
                                                                            }
                                                                        }
                                                                }

                                                        }
                                                }

                                        }
                                }
                        }
                }
        }
    }
    throw RuntimeException()
}

fun cyclesOf(n: Int): List<Int> = (0..99).map { it + n % 100 * 100 }