import utils.Utils.readFileLinesAsStrings

class Day9 {

    private val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath).map { it -> it.split("").filterNot { it -> it == "" } }

        val lowestPointsMap = findLowestPoints(inputs)

        println(lowestPointsMap)
        println(lowestPointsMap.values)
        val riskLevels = lowestPointsMap.values.map { it + 1 }

        return riskLevels.sum()
    }

    fun findSolution2(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath).map { it -> it.split("").filterNot { it -> it == "" } }

        val lowestPointsMap = findLowestPoints(inputs)

        val basins = lowestPointsMap.keys

        val basinSizes = basins.map { basin ->
            val uncheckedAdjacents = mutableListOf(basin)
            val uniqueAdjacents = checkAdjacents(inputs, uncheckedAdjacents, mutableListOf())
            uniqueAdjacents.count()
        }
        val sortedBasins = basinSizes.sortedDescending()

        return sortedBasins[0] * sortedBasins[1] * sortedBasins[2]
    }

    fun checkAdjacents(inputs: List<List<String>>, startingPoints: List<Pair<Int, Int>>, checkedPairs: MutableList<Pair<Int, Int>>): List<Pair<Int, Int>> {
        if (startingPoints.isEmpty()) return checkedPairs else {

            val newAdjacents = startingPoints.map { startingPoint ->
                val availableAdjacents = mutableListOf<Pair<Int, Int>>()
                val row = startingPoint.first
                val column = startingPoint.second
                val number = inputs[row][column].toInt()

                    val above =
                        if (row == 0) mapOf(Pair(10, 10) to 10) else mapOf(Pair(maxOf(row - 1, 0), column) to inputs[maxOf(row - 1, 0)][column].toInt())
                    val left =
                        if (column == 0) mapOf(Pair(10, 10) to 10) else mapOf(Pair(row, maxOf(column - 1)) to inputs[row][maxOf(column - 1, 0)].toInt())
                    val right =
                        if (column == (inputs[row].size - 1)) mapOf(Pair(10, 10) to 10) else mapOf(Pair(row, minOf(column + 1, inputs[row].size - 1)) to inputs[row][minOf(column + 1, inputs[row].size)].toInt())
                    val down =
                        if (row == inputs.size - 1) mapOf(Pair(10, 10) to 10) else mapOf(Pair(minOf(row + 1, inputs.size - 1), column) to inputs[minOf(row + 1, inputs.size - 1)][column].toInt())

                    val testList = listOf(above, left, right, down)
                    val filteredList = testList.filterNot { it.values.contains(10) || it.values.contains(9) }
                    filteredList.map { map -> availableAdjacents.add(map.keys.first()) }

                checkedPairs.add(startingPoint)
                availableAdjacents
            }

                val uncheckedAdjacents = newAdjacents.flatten().filterNot { newAdjs -> checkedPairs.any { it == newAdjs } }.distinct()
//                val checked = newAdjacents.flatten().filter { newAdjs -> checkedPairs.any { it == newAdjs } }.toMutableList()
//                checkedPairs.map { it -> checked.add(it) }

                return checkAdjacents(inputs, uncheckedAdjacents, checkedPairs.distinct().toMutableList())
        }

    }
    fun findLowestPoints(inputs: List<List<String>>): Map<Pair<Int, Int>, Int> {
        val lowestPoints = mutableListOf<Int>()

        val lowestPointsMap = mutableMapOf<Pair<Int, Int>, Int>()

        for (row in inputs.indices) {
            for (element in 0..inputs[row].size - 1) {
                val number = inputs[row][element].toInt()

                val above =
                    if (row == 0) 10 else inputs[maxOf(row - 1, 0)][element].toInt()
                val left =
                    if (element == 0) 10 else inputs[row][maxOf(element - 1, 0)].toInt()
                val right =
                    if (element == (inputs[row].size - 1)) 10 else inputs[row][minOf(element + 1, inputs[row].size - 1)].toInt()
                val down =
                    if (row == inputs.size - 1) 10 else inputs[minOf(row + 1, inputs.size - 1)][element].toInt()

                val testList = listOf(above, left, right, down)

                if ((number < testList.minOrNull()!!) && (testList.count {it == number } == 0)) {
//                    println("row, $row")
//                    println("number $number")
//                    println("$above, $left, $right, $down")
                    lowestPoints.add(number)

                    lowestPointsMap[Pair(row, element)] = number
                }
            }
        }
        return lowestPointsMap
    }
}