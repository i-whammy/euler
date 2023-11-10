package functions

import java.nio.file.Path

fun readFile(filePath: Path): String {
    return filePath.toFile().inputStream().readBytes().toString(Charsets.UTF_8)
}