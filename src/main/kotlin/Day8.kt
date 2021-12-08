import utils.Utils.readFileLinesAsStrings

class Day8 {
    private val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val inputLines = readFileLinesAsStrings(filepath)

        val outputs = inputLines.map {
            it.substringAfterLast("| ")
                .split(" ")
        }.flatten()
            .map { it ->
                it.split("")
                    .filterNot { it -> it == "" }
            }

        val filteredOutputs = outputs.filter { it.size == 2 || it.size == 3 || it.size == 4 || it.size == 7 }
        return filteredOutputs.size
    }

    fun findSolution2(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputLines = readFileLinesAsStrings(filepath)

        val outputNumbers = mutableListOf<Int>()

        for (line in inputLines) {
            val inputs = line.substringBefore(" |")
                .split(" ")
                .map { it ->
                    it.split("")
                        .filterNot { it -> it == "" }
                }

            val outputs = line.substringAfterLast("| ")
                .split(" ")
                .map { it ->
                    it.split("")
                        .filterNot { it -> it == "" }
                }

            val uniques = (inputs + outputs).map { it.sorted() }.distinct()

            val number1 = uniques.filter { it.size == 2 }.flatten().sorted()
            val number4 = uniques.filter { it.size == 4 }.flatten().sorted()
            val number7 = uniques.filter { it.size == 3 }.flatten().sorted()
            val number8 = uniques.filter { it.size == 7 }.flatten().sorted()

            val zeroSizOrNine = uniques.filter { it.size == 6 }
            val twoThreeOrFive = uniques.filter { it.size == 5 }

            val number6 = zeroSizOrNine.filter {
                it.plus(number1).distinct().size == 7
            }.first().sorted()

            val number5 = twoThreeOrFive.filter {
                it.plus(number6).distinct().size == 6
            }.first().sorted()

            val topRightLine = number8.filterNot { number8 -> number6.any { it == number8 } }.first()
            val bottomRightLine = number1.filterNot { number1 -> number1 == topRightLine }.first()

            val number9 = (number5 + topRightLine).distinct().sorted()

            val number0 = zeroSizOrNine.first { it != number6 && it != number9 }.sorted()

            val twoOrThree = twoThreeOrFive.filterNot { it == number5 }
            val number2 = twoOrThree.filterNot { it.contains(bottomRightLine) }.first().sorted()
            val number3 = twoOrThree.filterNot { it == number2 }.first().sorted()

            val sortedOutputs = outputs.map { it.sorted() }

            val arrayOfNumberCodes = mutableListOf(
                number0, number1, number2, number3, number4, number5, number6, number7, number8, number9
            )

            var stringedDigits = ""
            for (output in sortedOutputs) {
                val sorted = output.sorted()

                val digit = arrayOfNumberCodes.indexOf(sorted)

                stringedDigits = StringBuilder(stringedDigits).append(digit.toString()).toString()
            }
            outputNumbers.add(stringedDigits.toInt())

        }
        return outputNumbers.sum()
    }
}