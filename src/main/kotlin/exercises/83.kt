package exercises

import functions.readFile
import kotlin.io.path.Path
import kotlin.math.min

fun main() {
    println(sumUp(testMatrix, 5, 5))
//    println(sumUp(matrix, MATRIX_ROW_LENGTH, MATRIX_COLUMN_LENGTH))
    kotlin.system.exitProcess(0)
}

private fun sumUp(matrix: List<List<Int>>, rowLength: Int, columnLength: Int): Int {
    val sumUppedMatrix = matrix.map { it.toTypedArray() }.toTypedArray()
//    // fill edge
//    sumUppedMatrix[rowLength - 1][columnLength - 1] = matrix[rowLength - 1][columnLength - 1]
//    (rowLength - 2 downTo 0).forEach { y ->
//        sumUppedMatrix[y][4] = sumUppedMatrix[y + 1][4]!! + matrix[y][4]
//    }
//    (columnLength - 2 downTo 0).forEach { x ->
//        sumUppedMatrix[4][x] = sumUppedMatrix[4][x + 1]!! + matrix[4][x]
//    }
    // confirm right and bottom
    (0..<columnLength - 1).forEach { x ->
        (0..<rowLength - 1).forEach { y ->
            sumUppedMatrix[y][x] = min(
                valueOf(x - 1, y, sumUppedMatrix.toList()),
                valueOf(x, y - 1, sumUppedMatrix.toList()),
            ) + sumUppedMatrix[y][x]
        }
    }
    // fill edge
    sumUppedMatrix[rowLength - 1][columnLength - 1] = matrix[rowLength - 1][columnLength - 1]
    (rowLength - 2 downTo 0).forEach { y ->
        sumUppedMatrix[y][4] = sumUppedMatrix[y + 1][4] + matrix[y][4]
    }
    (columnLength - 2 downTo 0).forEach { x ->
        sumUppedMatrix[4][x] = sumUppedMatrix[4][x + 1] + matrix[4][x]
    }

    // left and top
    (rowLength - 2 downTo 0).forEach { y ->
        (columnLength - 2 downTo 0).forEach { x ->
            sumUppedMatrix[y][x] =
                min(valueOf(x, y + 1, sumUppedMatrix.toList()), valueOf(x+1, y, sumUppedMatrix.toList())) + sumUppedMatrix[y][x]
        }
    }

    sumUppedMatrix.forEach { println(it.toList()) }

    return sumUppedMatrix.first().first()
}

private fun valueOf(x: Int, y: Int, matrix: List<List<Int?>>): Int {
    return if (x < 0 || y < 0) 0
    else if (y >= 5 || x >= 5 || matrix[y][x] == null || x >= matrix[y].filterNotNull().size) OUTLIER
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