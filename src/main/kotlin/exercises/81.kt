package exercises

import functions.readFile
import java.math.BigInteger
import kotlin.io.path.Path

private const val MATRIX_COLUMN_LENGTH = 80
private const val MATRIX_ROW_LENGTH = 80

private val testMatrix = listOf(
    listOf(BigInteger.valueOf(131), BigInteger.valueOf(673), BigInteger.valueOf(234), BigInteger.valueOf(103), BigInteger.valueOf(18)),
    listOf(BigInteger.valueOf(201), BigInteger.valueOf(96), BigInteger.valueOf(342), BigInteger.valueOf(965), BigInteger.valueOf(150)),
    listOf(BigInteger.valueOf(630), BigInteger.valueOf(803), BigInteger.valueOf(746), BigInteger.valueOf(422), BigInteger.valueOf(111)),
    listOf(BigInteger.valueOf(537), BigInteger.valueOf(699), BigInteger.valueOf(497), BigInteger.valueOf(121), BigInteger.valueOf(956)),
    listOf(BigInteger.valueOf(805), BigInteger.valueOf(732), BigInteger.valueOf(524), BigInteger.valueOf(37), BigInteger.valueOf(331))
)

fun main() {
    val matrix = readFile(Path("src/main/resources/0081_matrix.txt"))
        .split("\n")
        .filter { it.isNotEmpty() }
        .map {
            it.split(",")
                .map { s -> s.toBigInteger() }
        }
    val sumUppedMatrix = generateEmptyArrays(MATRIX_ROW_LENGTH, MATRIX_COLUMN_LENGTH)
    val testSumUppedMatrix = generateEmptyArrays(5, 5)
    println(fillUpMatrix(matrix, sumUppedMatrix, MATRIX_ROW_LENGTH, MATRIX_COLUMN_LENGTH).sumOfMinimalPath())
    println(fillUpMatrix(testMatrix, testSumUppedMatrix, 5, 5).sumOfMinimalPath())
    kotlin.system.exitProcess(0)
}

private fun fillUpMatrix(
    rawMatrix: List<List<BigInteger>>,
    matrix: Array<Array<BigInteger?>>,
    matrixRowIndex: Int,
    matrixColumnIndex: Int
): List<List<BigInteger>> {
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

private fun List<List<BigInteger>>.sumOfMinimalPath(): BigInteger = this.last().last()

private fun generateEmptyArrays(row: Int, column: Int) = arrayOfNulls<Array<BigInteger?>>(row)
    .map { arrayOfNulls<BigInteger>(column) }
    .toTypedArray()