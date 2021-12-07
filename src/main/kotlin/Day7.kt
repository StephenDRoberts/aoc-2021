import utils.Utils
import utils.Utils.readFileLinesAsStrings
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor

class Day7 {
    private val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath).first().split(",").map { it.toInt() }.sorted()

        var medianLocation = ceil(inputs.size / 2.0 - 1).toInt()
        val median = inputs[medianLocation]

        val answerArray = inputs.map {
            abs(it.minus(median))
        }
        return answerArray.sum()
    }

    fun findSolution2(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath).first().split(",").map { it.toInt() }.sorted()

        val average = floor(inputs.average())

        val answerArray = inputs.map {
            val absolute = abs(it.minus(average))
            var sum = 0
            for(i in 0..absolute.toInt()){
                sum += i
         }
            sum
        }
        return answerArray.sum()
    }
}