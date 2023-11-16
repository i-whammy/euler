package exercises

import functions.isPrime
import java.math.BigInteger
import kotlin.math.sqrt


private const val UPPER_LIMIT = 50
private val primes = (2..sqrt(UPPER_LIMIT.toDouble()).toInt()).filter { isPrime(it.toBigInteger()) }

fun main() {
    var answers = mutableSetOf(0)
    (2..4).forEach { n ->
        val ans = mutableSetOf<Int>()
        for (p in primes) {
            val q = BigInteger.valueOf(p.toLong()).pow(n)
            if (q > UPPER_LIMIT.toBigInteger()) {
                break
            }
            val r = q.toInt()
            answers.forEach {
                if (it + r <= UPPER_LIMIT) ans.add(it + r)
                println(ans)
            }
        }
        answers = ans
        println("ans - $answers")
    }
    println(answers.size)
    kotlin.system.exitProcess(0)
}