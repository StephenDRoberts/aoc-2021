import utils.Utils.readFileLinesAsStrings
import kotlin.math.abs

class Day5 {
    private val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val stringedLines = readFileLinesAsStrings(filepath)
        val coordinateInputs = convertLinesToStartAndEndCoords(stringedLines)
        val inputsWithoutDiags = filterIfDiagonal(coordinateInputs)

        val fullPath = inputsWithoutDiags.map { plotOutSingleStartAndEnd(it) }.flatten()
        val objectOfRepeats = fullPath.groupingBy { it }.eachCount().filter { it.value > 1 }
        return objectOfRepeats.entries.count()
    }

    fun findSolution2(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val stringedLines = readFileLinesAsStrings(filepath)
        val coordinateInputs = convertLinesToStartAndEndCoords(stringedLines)
        val inputsWithoutDiags = filterIfDiagonal(coordinateInputs)
        val diagsOnly = filterForDiagonal(coordinateInputs)

        val fullPath =
            inputsWithoutDiags.map { plotOutSingleStartAndEnd(it) }.flatten() + diagsOnly.map { plotOutSingleStartAndEndForDiagonals(it) }.flatten()

        val objectOfRepeats = fullPath.groupingBy { it }.eachCount().filter { it.value > 1 }
        return objectOfRepeats.entries.count()
    }

    fun filterIfDiagonal(list: List<StartAndEnd>): List<StartAndEnd> =
        list.filter { startAndEnd ->
            startAndEnd.first.first  == startAndEnd.second.first ||
            startAndEnd.first.second  == startAndEnd.second.second
        }


    fun filterForDiagonal(list: List<StartAndEnd>): List<StartAndEnd> =
        list.filterNot { startAndEnd ->
            startAndEnd.first.first  == startAndEnd.second.first ||
                    startAndEnd.first.second  == startAndEnd.second.second
        }

    fun convertLinesToStartAndEndCoords(list: List<String>): List<StartAndEnd>
        = list.map { convertLineToStartAndEndCoords(it) }


    fun convertLineToStartAndEndCoords(line: String): StartAndEnd{
        val stringCoords = line.split(" -> ").filterNot { it == " -> " }
        val start = stringCoords.first().split(",")
        val startCoords = Coords(start[0].toInt(), start[1].toInt())
        val end = stringCoords[1].split(",")
        val endCoords = Coords(end[0].toInt(), end[1].toInt())

        return StartAndEnd(startCoords, endCoords)
    }

    fun plotOutSingleStartAndEnd(startAndEnd: StartAndEnd): List<Coords> {
        val fullPathList = mutableListOf<Coords>()
        val start = startAndEnd.first
        val end = startAndEnd.second

        for(x in minOf(start.first, end.first)..maxOf(start.first, end.first)) {
            for(y in minOf(start.second, end.second)..maxOf(start.second, end.second)) {
                fullPathList.add(Coords(x, y))
            }
        }
        return fullPathList
    }

    fun plotOutSingleStartAndEndForDiagonals(startAndEnd: StartAndEnd): List<Coords> {
        val start = startAndEnd.first
        val end = startAndEnd.second
        val fullPathList = mutableListOf<Coords>()

        val xDistance = end.first - start.first
        val yDistance = end.second - start.second

        for (i in 0..abs(xDistance)){

            fullPathList.add(
                Pair(
                    start.first + i * (xDistance.div(abs(xDistance).coerceAtLeast(1))),
                    start.second + i * (yDistance.div(abs(yDistance).coerceAtLeast(1)))
                )
            )
        }
        return fullPathList
    }
}

typealias StartAndEnd = Pair<Coords, Coords>
typealias Coords = Pair<Int, Int>