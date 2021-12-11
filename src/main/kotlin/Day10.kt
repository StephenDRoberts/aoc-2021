import utils.Utils.readFileLinesAsStrings

class Day10 {
    private val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath)

        val splitInputs = inputs.map { it -> it.split("").filterNot { it == "" } }

        val stack = mutableListOf<String>()
        val rightSidedCharacters = listOf("]", "}", ")", ">")
        val badCharacters = mutableListOf<String>()

        for(row in splitInputs) {
            for (input in row) {
                stack.add(input)
                if (rightSidedCharacters.any { char -> char == input }) {
                    val check = checkPair(stack[stack.size - 2], input)
                    if (!check) {
                        badCharacters.add(input)
                        break
                    } else {
                        stack.removeLast()
                        stack.removeLast()
                    }
                }
            }
        }

    val scoring = mapOf(
        ")" to 3,
        "]" to 57,
        "}" to 1197,
        ">" to 25137
    )

    val summarisedBadCharacters = badCharacters.groupingBy { it }.eachCount()
    val numbers = summarisedBadCharacters.map { it ->
        val key = it.key
        val count = it.value
        val score = scoring.getOrDefault(key, 0)
        count * score
    }

    return numbers.sum()
    }

    fun findSolution2(inputPuzzle: String): Long {
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath)

        val splitInputs = inputs.map { it -> it.split("").filterNot { it == "" } }
        val originalInputs = splitInputs.toMutableList()

        val rightSidedCharacters = listOf("]", "}", ")", ">")

        for(row in splitInputs) {
            val stack = mutableListOf<String>()
            for (input in row) {
                stack.add(input)
                if (rightSidedCharacters.any { char -> char == input }) {
                    val check = checkPair(stack[stack.size - 2], input)
                    if (!check) {
                        originalInputs.remove(row)
                        break
                    } else {
                        stack.removeLast()
                        stack.removeLast()
                    }
                }
            }
        }
        // NEED TO REFACTOR - DUPLICATING LOOP
        val missingCharacters = originalInputs.map { row ->
            val stack = mutableListOf<String>()
            for (input in row) {
                stack.add(input)
                if (rightSidedCharacters.any { char -> char == input }) {
                    val check = checkPair(stack[stack.size - 2], input)
                    if (!check) {
                        break
                    } else {
                        stack.removeLast()
                        stack.removeLast()
                    }
                }
            }
            stack.map { it -> flipCharacter(it) }.reversed()
        }

        val listOfSums = missingCharacters.map { it -> calculateScorePart2(it) }
        val medianIndex = (listOfSums.size - 1) / 2

        return listOfSums.sortedDescending()[medianIndex]
    }

    private fun checkPair(left: String, right: String) : Boolean {
        return when(left) {
            "[" -> right == "]"
            "{" -> right == "}"
            "(" -> right == ")"
            "<" -> right == ">"
            else -> false
        }
    }

    private fun flipCharacter(character: String): String {
        return when(character) {
            "[" -> "]"
            "{" -> "}"
            "(" -> ")"
            "<" -> ">"
            else -> ""
        }
    }

    private fun calculateScorePart2(missingCharacters: List<String>): Long{
        val scoring = mapOf(
            ")" to 1,
            "]" to 2,
            "}" to 3,
            ">" to 4
        )
        var sum = 0L
        missingCharacters.map { it ->
            val score = scoring.getOrDefault(it, 0)
            sum = (sum * 5) + score
        }
        return sum
    }
}