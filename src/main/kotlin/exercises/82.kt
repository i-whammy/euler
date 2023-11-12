package exercises

import functions.readFile
import kotlin.io.path.Path
import kotlin.math.min

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

fun main() {
    val matrix = readFile(Path("src/main/resources/0082_matrix.txt"))
        .split("\n")
        .filter { it.isNotEmpty() }
        .map {
            it.split(",")
                .map { s -> s.toInt() }
        }
    val sumUppedMatrix = generateEmptyArrays(MATRIX_ROW_LENGTH, MATRIX_COLUMN_LENGTH)
    (0..<MATRIX_COLUMN_LENGTH).forEach { x ->
        (0..<MATRIX_ROW_LENGTH).forEach { y ->
            sumUppedMatrix[y][x] = matrix[y][x] + min(valueOf(x,y-1,sumUppedMatrix), valueOf(x-1,y,sumUppedMatrix))
        }
        (MATRIX_ROW_LENGTH-1 downTo 0).forEach { y ->
            sumUppedMatrix[y][x] = min(matrix[y][x] + valueOf(x,y+1, sumUppedMatrix), sumUppedMatrix[y][x]!!)
        }
    }
    var min = OUTLIER
    (0..<MATRIX_ROW_LENGTH).forEach {
        min = min(sumUppedMatrix[it][MATRIX_COLUMN_LENGTH-1]!!, min)
    }
    println(min)

    kotlin.system.exitProcess(0)
}

private fun valueOf(x: Int, y: Int, grid: Array<Array<Int?>>): Int {
    if (x < 0) return 0
    if (y < 0 || y >= MATRIX_ROW_LENGTH || x >= grid[y].filterNotNull().size) return OUTLIER
    return grid[y][x]!!
}

private fun generateEmptyArrays(row: Int, column: Int) = arrayOfNulls<Array<Int?>>(row)
    .map { arrayOfNulls<Int>(column) }
    .toTypedArray()