package exercises.to60

import functions.readFile
import kotlin.experimental.xor
import kotlin.io.path.Path

fun main() {
    val bytes =
        readFile(Path("src/main/resources/0059_cipher.txt")).split(",").map { it.toByte() }
            .toByteArray()
    val maxKey = lowerCaseRange.flatMap { x ->
        lowerCaseRange.flatMap { y ->
            lowerCaseRange.map { z ->
                val key = byteArrayOf(x, y, z)
                val score = bytes.decrypt(key)
                    .filter { upperCaseRange.contains(it) || lowerCaseRange.contains(it) }
                    .sumOf { it.toInt() }
                key to score
            }
        }
    }.maxBy { it.second }.first
    println(bytes.decrypt(maxKey).sum())
    kotlin.system.exitProcess(0)
}

fun ByteArray.decrypt(key: ByteArray): ByteArray {
    return this.mapIndexed { index, byte ->
        byte.xor(key[index % key.size])
    }.toByteArray()
}

private val upperCaseRange = ('A'..'Z').map { it.code.toByte() }
private val lowerCaseRange = ('a'..'z').map { it.code.toByte() }
