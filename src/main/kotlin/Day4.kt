import org.springframework.stereotype.Component
import utils.Utils.readFileLinesAsStrings

@Component
class Day4 {
    val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val allData = readFileLinesAsStrings(filepath)
        val unformattedInputBalls = allData[0]
        val formattedInputsBalls = unformattedInputBalls.split(",").map { it.toInt() }
        var winningIndex = 100000
        var winningCard = listOf<List<Int>>()

        for(i in 2..allData.size step 6) {
            val unformattedGameCard1 = allData.slice(IntRange(i, i+4))
            val formattedGameCard1 = formatGameCard(unformattedGameCard1)
            val minIndexForGameCard1Rows = minIndexOfGameCard(formattedGameCard1, formattedInputsBalls)
            val transposedGameCard1 = transposeRowsToColumns(formattedGameCard1)
            val minIndexForGameCard1Columns = minIndexOfGameCard(transposedGameCard1, formattedInputsBalls)
            val minIndex = minOf(minIndexForGameCard1Rows, minIndexForGameCard1Columns)
            if(minIndex < winningIndex) {
                winningIndex = minIndex
                winningCard = formattedGameCard1
            }
        }

        val winningNumber = formattedInputsBalls[winningIndex]

        val reducedDrawInputs = formattedInputsBalls.slice(IntRange(0, winningIndex))

        val winningCardRemainingNumbersSum = removeCalledElements(winningCard, reducedDrawInputs).sum()

        return winningCardRemainingNumbersSum * winningNumber
    }

    fun findSolution2(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val allData = readFileLinesAsStrings(filepath)
        val unformattedInputBalls = allData[0]
        val formattedInputsBalls = unformattedInputBalls.split(",").map { it.toInt() }
        var losingIndex = 0
        var losingCard = listOf<List<Int>>()

        for(i in 2..allData.size step 6) {
            val unformattedGameCard1 = allData.slice(IntRange(i, i+4))
            val formattedGameCard1 = formatGameCard(unformattedGameCard1)
            val minIndexForGameCard1Rows = minIndexOfGameCard(formattedGameCard1, formattedInputsBalls)
            val transposedGameCard1 = transposeRowsToColumns(formattedGameCard1)
            val minIndexForGameCard1Columns = minIndexOfGameCard(transposedGameCard1, formattedInputsBalls)
            val minIndex = minOf(minIndexForGameCard1Rows, minIndexForGameCard1Columns)
            if(minIndex > losingIndex) {
                losingIndex = minIndex
                losingCard = formattedGameCard1
            }
        }

        val winningNumber = formattedInputsBalls[losingIndex]

        val reducedDrawInputs = formattedInputsBalls.slice(IntRange(0, losingIndex))

        val winningCardRemainingNumbersSum = removeCalledElements(losingCard, reducedDrawInputs).sum()

        return winningCardRemainingNumbersSum * winningNumber
    }

    fun removeCalledElements (card: List<List<Int>>, reducedDrawInputs: List<Int>): List<Int> =
        card.flatten().filterNot { it -> reducedDrawInputs.contains(it) }

    fun reduceToSum (list: List<Int>) = list.sum()

    fun formatGameCard(list: List<String>): List<List<Int>> =
        list.map { it.split(" ").filterNot { filterIt -> filterIt == "" }.map { mapIt -> mapIt.toInt() } }

    fun minIndexOfGameCard (card: List<List<Int>>, drawnBalls: List<Int>): Int {
        var min = 1000000000
        for (row in card) {
            val maxIndexForRow = maxIndexOfRowAgainstDraw(row, drawnBalls)
            if(maxIndexForRow < min) min = maxIndexForRow
        }
        return min
    }

    fun maxIndexOfRowAgainstDraw (row: List<Int>, drawnBalls: List<Int>): Int {
        var max = 0;
        for (number in row) {
            val index = drawnBalls.indexOf(number)
            if(index > max) max = index
        }
        return max
    }

    fun transposeRowsToColumns(rows: List<List<Int>>): List<List<Int>> {
        val transposedRows = mutableListOf<MutableList<Int>>()

        for(element in 0 until rows.first().size) {
            val newRow = mutableListOf<Int>()
            for (row in rows) {
                newRow.add(row[element])
            }
            transposedRows.add(newRow)
        }
        return transposedRows
    }
}