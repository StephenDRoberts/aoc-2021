import org.springframework.stereotype.Component
import utils.Utils.readFileLinesAsInts

@Component
class Day1() {
    val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val inputArray = readFileLinesAsInts(filepath)

        var count: Int = 0;
        inputArray.mapIndexed { index, _ ->
            if(inputArray[index] > inputArray[maxOf(index-1,0)]) count ++
        }

        return count
    }

    fun findSolution2(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val inputArray = readFileLinesAsInts(filepath)

        var count: Int = 0;
        inputArray.mapIndexed { index, _ ->
            if(index > 2 && inputArray[index] > inputArray[maxOf(index-3,0)]) count ++
        }

        return count
    }
}