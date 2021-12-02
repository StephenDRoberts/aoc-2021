import utils.Utils.readFileLinesAsPairsOfStrings

class Day2 {
    val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String, delimeter: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val pairedLines = readFileLinesAsPairsOfStrings(filepath, delimeter)

        var horizontal = 0
        var depth = 0

        pairedLines.map { pair ->
            when (pair.first) {
                "forward" -> horizontal += pair.second.toInt()
                "up" -> depth -= pair.second.toInt()
                "down" -> depth += pair.second.toInt()
            }
        }
        return horizontal * depth
    }

    fun findSolution2(inputPuzzle: String, delimeter: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val pairedLines = readFileLinesAsPairsOfStrings(filepath, delimeter)

        var horizontal = 0
        var depth = 0
        var aim = 0

        pairedLines.map { pair ->
            when (pair.first) {
                "forward" -> {
                    horizontal += pair.second.toInt()
                    depth += pair.second.toInt() * aim
                }
                "up" -> aim -= pair.second.toInt()
                "down" -> aim += pair.second.toInt()
            }
        }
        return horizontal * depth
    }
}