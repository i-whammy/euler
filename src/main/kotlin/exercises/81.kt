package exercises

import functions.readFile
import kotlin.io.path.Path

private const val MATRIX_COLUMN_LENGTH = 80
private const val MATRIX_ROW_LENGTH = 80

private val testMatrix = listOf(
    listOf(131, 673, 234, 103, 18),
    listOf(201, 96, 342, 965, 150),
    listOf(630, 803, 746, 422, 111),
    listOf(537, 699, 497, 121, 956),
    listOf(805, 732, 524, 37, 331)
)

fun main() {
    val matrix = readFile(Path("src/main/resources/0081_matrix.txt"))
        .split("\n")
        .filter { it.isNotEmpty() }
        .map {
            it.split(",")
                .map { s -> s.toInt() }
        }
    val sumUppedMatrix = generateEmptyArrays(MATRIX_ROW_LENGTH, MATRIX_COLUMN_LENGTH)
    val testSumUppedMatrix = generateEmptyArrays(5, 5)
    println(fillUpMatrix(matrix, sumUppedMatrix, MATRIX_ROW_LENGTH, MATRIX_COLUMN_LENGTH).sumOfMinimalPath())
    println(fillUpMatrix(testMatrix, testSumUppedMatrix, 5, 5).sumOfMinimalPath())
    kotlin.system.exitProcess(0)
}

private fun fillUpMatrix(
    rawMatrix: List<List<Int>>,
    matrix: Array<Array<Int?>>,
    matrixRowIndex: Int,
    matrixColumnIndex: Int
): List<List<Int>> {
    // fill up the top
    matrix[0][0] = rawMatrix.first().first()
    // fill up the left column and the top row
    (1..<matrixColumnIndex).forEach { columnIndex ->
        val baseRowMatrix = rawMatrix[0]
        matrix[0][columnIndex] = baseRowMatrix[columnIndex] + matrix[0][columnIndex - 1]!!
    }
    // fill up the left column
    (1..<matrixRowIndex).forEach { rowIndex ->
        matrix[rowIndex][0] = rawMatrix[rowIndex][0] + matrix[rowIndex - 1][0]!!
    }
    // fill up the remaining using lower number
    (1..<matrixColumnIndex).forEach { columnIndex ->
        (1..<matrixRowIndex).forEach { rowIndex ->
            (1..<columnIndex).forEach { c ->
                matrix[rowIndex][c] =
                    rawMatrix[rowIndex][c] + minOf(matrix[rowIndex][c - 1]!!, matrix[rowIndex - 1][c]!!)
            }
            (1..<rowIndex).forEach { r ->
                matrix[r][columnIndex] =
                    rawMatrix[r][columnIndex] + minOf(matrix[r - 1][columnIndex]!!, matrix[r][columnIndex - 1]!!)
            }
            matrix[rowIndex][columnIndex] = rawMatrix[rowIndex][columnIndex] + minOf(
                matrix[rowIndex - 1][columnIndex]!!,
                matrix[rowIndex][columnIndex - 1]!!
            )
        }
    }
    return matrix.map { row -> row.map { column -> column!! } }
}

private fun List<List<Int>>.sumOfMinimalPath(): Int = this.last().last()

private fun generateEmptyArrays(row: Int, column: Int) = arrayOfNulls<Array<Int?>>(row)
    .map { arrayOfNulls<Int>(column) }
    .toTypedArray()