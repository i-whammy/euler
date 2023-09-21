package exercises

import java.math.BigInteger

// https://projecteuler.net/problem=13

private val chainCountMap = mutableMapOf<Long, BigInteger>()

fun main() {
    println(getLongestChainNumber(1_000_000))
}

fun getLongestChainNumber(until: Int): Int {
    var max = 1
    var maxCount = BigInteger.ONE
    (1..until).forEach { i ->
        getChainCountOf(i.toLong())
            .takeIf { maxCount < it }
            ?.also { maxCount = it }?.also { max = i }
    }
    return max
}

fun getChainCountOf(number: Long): BigInteger {
    var chainNode: Long = number
    var chainCount = BigInteger.ONE
    while (chainNode != 1L) {
        if (chainCountMap.containsKey(chainNode)) return chainCount + chainCountMap[chainNode]!!
        if (chainNode % 2 == 0L) {
            chainNode /= 2
        }
        else {
            chainNode = chainNode * 3 + 1
        }
        chainCount++
    }
    chainCountMap[number] = chainCount - BigInteger.ONE
    return chainCount
}