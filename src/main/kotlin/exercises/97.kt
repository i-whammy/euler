package exercises

fun main() {
    var last10Digits = 28433L
    repeat(7_830_457) {
        last10Digits = last10Digits * 2 % 10_000_000_000
    }
    println(last10Digits + 1L)
    kotlin.system.exitProcess(0)
}