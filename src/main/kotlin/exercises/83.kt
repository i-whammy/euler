package exercises

import functions.readFile
import kotlin.io.path.Path
import kotlin.math.min

fun main() {
    println(sumUp(testMatrix, 5, 5))
    println(sumUp(matrix, MATRIX_ROW_LENGTH, MATRIX_COLUMN_LENGTH))
    kotlin.system.exitProcess(0)
}

private fun sumUp(matrix: List<List<Int>>, rowLength: Int, columnLength: Int): Int {
    val sumUppedMatrix = generateEmptyArrays(rowLength, columnLength)
    (0..<rowLength).forEach { y ->
        (0..<columnLength).forEach { x ->
            sumUppedMatrix[y][x] = OUTLIER
        }
    }
    sumUppedMatrix[0][0] = matrix[0][0]
    repeat(rowLength * columnLength) {
        (0..<rowLength).forEach { y ->
            (0..<columnLength).forEach { x ->
                var tmp = OUTLIER
                tmp = min(valueOf(x-1,y,sumUppedMatrix), tmp)
                tmp = min(valueOf(x+1,y,sumUppedMatrix), tmp)
                tmp = min(valueOf(x,y-1,sumUppedMatrix), tmp)
                tmp = min(valueOf(x,y+1,sumUppedMatrix), tmp)
                sumUppedMatrix[y][x] = min(matrix[y][x] + tmp, sumUppedMatrix[y][x]!!)
            }
        }
    }
    sumUppedMatrix.forEach { println(it.toList()) }

    return sumUppedMatrix.last().last()!!
}

private fun valueOf(x: Int, y: Int, matrix: Array<Array<Int?>>): Int {
    return if (y < 0 || y >= matrix.size || x < 0 || x >= matrix[y].size) OUTLIER
    else matrix[y][x]!!
}

private fun generateEmptyArrays(row: Int, column: Int) = arrayOfNulls<Array<Int?>>(row)
    .map { arrayOfNulls<Int>(column) }
    .toTypedArray()

private fun Array<Array<Int>>.toList(): List<List<Int?>> = this.map { it.toList() }

private const val MATRIX_COLUMN_LENGTH = 80
private const val MATRIX_ROW_LENGTH = 80

private const val OUTLIER = Integer.MAX_VALUE / 2

private val testMatrix = listOf(
    listOf(131, 673, 234, 103, 18),
    listOf(201, 96, 342, 965, 150),
    listOf(630, 803, 746, 422, 111),
    listOf(537, 699, 497, 121, 956),
    listOf(805, 732, 524, 37, 331)
)

private val matrix = readFile(Path("src/main/resources/0082_matrix.txt"))
    .split("\n")
    .filter { it.isNotEmpty() }
    .map {
        it.split(",")
            .map { s -> s.toInt() }
    }