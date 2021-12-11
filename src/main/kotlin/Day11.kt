import utils.Utils.readFileLinesAsStrings

class Day11 {

    private val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath).map { row -> row.split("").filterNot { it -> it.isEmpty() }.map { digit -> digit.toInt() } }

        val coordinates = inputs.convertToCoords().toMutableMap()
        var totalFlashes = 0

        for (i in 0 until 100) {
            coordinates.map { entry ->
                val key = entry.key
                val value = entry.value
                val newValue = (value + 1).mod(10)
                coordinates.put(key, newValue)
            }

            val flashesToProcess = coordinates.filter { it.value == 0 }.map { it.key }.toMutableList()
            totalFlashes += flashesToProcess.size

            while (flashesToProcess.isNotEmpty()) {
                val processing = flashesToProcess[0]
                flashesToProcess.removeFirst()
                val neighbours = processing.getNeighbours()

                neighbours.map { it ->
                    val value = coordinates[it]!!

                    if(value !=0) {
                        val newValue = (value + 1).mod(10)

                        if (newValue == 0) {
                            flashesToProcess.add(it)
                            totalFlashes++
                        }
                        coordinates.put(it, newValue)
                    }
                }
            }
        }
        return totalFlashes
    }

    fun findSolution2(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath).map { row -> row.split("").filterNot { it -> it.isEmpty() }.map { digit -> digit.toInt() } }

        val coordinates = inputs.convertToCoords().toMutableMap()
        var totalFlashes = 0
        var stepAllFlahsed = 0

        for (i in 0 until 1000) {
            coordinates.map { entry ->
                val key = entry.key
                val value = entry.value
                val newValue = (value + 1).mod(10)
                coordinates.put(key, newValue)
            }

            val flashesToProcess = coordinates.filter { it.value == 0 }.map { it.key }.toMutableList()
            totalFlashes += flashesToProcess.size

            while (flashesToProcess.isNotEmpty()) {
                val processing = flashesToProcess[0]
                flashesToProcess.removeFirst()
                val neighbours = processing.getNeighbours()

                neighbours.map { it ->
                    val value = coordinates[it]!!

                    if(value !=0) {
                        val newValue = (value + 1).mod(10)

                        if (newValue == 0) {
                            flashesToProcess.add(it)
                            totalFlashes++
                        }
                        coordinates.put(it, newValue)
                    }
                }
            }

            if(coordinates.checkAllFlashed()) {
                stepAllFlahsed = i + 1
                break
            }
        }
        return stepAllFlahsed
    }

    private fun List<List<Int>>.convertToCoords(): Map<Coords, Int> {
        val map = mutableMapOf<Coords, Int>()
        for (row in this.indices) {
            for (column in this[row].indices) {
                map[Pair(row, column)] = this[row][column]
            }
        }
        return map
    }

    private fun Coords.getNeighbours(): List<Coords> {
        val row = this.first
        val column = this.second

        val boundedRowMin = if (row == 0) 0 else -1
        val boundedRowMax = if (row == 9) 0 else 1

        val boundedColumnMin = if (column == 0) 0 else -1
        val boundedColumnMax = if (column == 9) 0 else 1

        val neighbours = mutableListOf<Coords>()
        for (rowOffset in IntRange(boundedRowMin, boundedRowMax)) {
            for (columnOffset in IntRange(boundedColumnMin, boundedColumnMax)) {
                val newRow = row + rowOffset
                val newColumn = column + columnOffset
                neighbours.add(Coords(newRow, newColumn))
            }
        }
        return neighbours.filterNot { it == this }.distinct()
    }

    private fun Map<Coords, Int>.checkAllFlashed(): Boolean {
        return this.values.sum() == 0
    }
}

