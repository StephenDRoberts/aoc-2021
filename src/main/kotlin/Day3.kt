import org.springframework.stereotype.Component
import utils.Utils.readFileLinesAsStrings

@Component
class Day3 {
    val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"

        val inputArray = readFileLinesAsStrings(filepath)

        var gammaBinary = mutableListOf<Int>()
        var epsilonBinary = mutableListOf<Int>()


        val splitArray = inputArray.map {
            it.chunked(1)
        }

        val binarySize = splitArray[0].size

        for(i in 0 until binarySize){
            val array = mutableListOf<Int>()

            splitArray.map {
                array.add(it[i].toInt())
            }

            val zeros = array.count { it === 0 }
            val ones = array.count { it === 1 }

            if(zeros > ones) {
                gammaBinary.add(0)
                epsilonBinary.add(1)
            } else {
                gammaBinary.add(1)
                epsilonBinary.add(0)
            }
        }

        val gamma = convertBinaryToDecimal(gammaBinary)
        val epsilon = convertBinaryToDecimal(epsilonBinary)

        return gamma * epsilon
    }

    fun findSolution2(inputPuzzle: String): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputArray = readFileLinesAsStrings(filepath)

        val oxygenBinary = filterArrayOfBinaries(inputArray, 0, "oxygen")
        val oxygenArray = mutableListOf<Int>()

        oxygenBinary.first().chunked(1).map { it ->
            oxygenArray.add(it.toInt())
        }

        val oxygen = convertBinaryToDecimal(oxygenArray)

        val co2ScrubberBinary = filterArrayOfBinaries(inputArray, 0, "co2")
        val co2Array = mutableListOf<Int>()
        co2ScrubberBinary.first().chunked(1).map { it -> co2Array.add(it.toInt()) }

        val co2Scrubber = convertBinaryToDecimal(co2Array)
        return oxygen * co2Scrubber
    }

    fun filterArrayOfBinaries(list: List<String>, index: Int, type: String): List<String> {
        return if(list.size == 1) {
            list
        } else {
        var arrayForRecursion = mutableListOf<String>()
            val splitArray = list.map {
                it.chunked(1)
            }

            val array = mutableListOf<Int>()

            splitArray.map {
                array.add(it[index].toInt())
            }

            val zeros = array.count { it === 0 }
            val ones = array.count { it === 1 }
            var valueToFilter = 0
            if(zeros > ones) {
                valueToFilter = 0
            } else {
                valueToFilter = 1
            }
            if(type=="co2") valueToFilter = 1-valueToFilter

            val filterredArray = splitArray
                .filter { it ->
                    it[index] == valueToFilter.toString()
            }

            filterredArray.map {
                arrayForRecursion.add(it.joinToString(""))
            }
            filterArrayOfBinaries(arrayForRecursion, index +1, type)
        }
    }


    fun convertBinaryToDecimal(list: List<Int>): Int {
        val reversed = list.reversed()

        var sum = 0
        reversed.mapIndexed { index, i -> sum += ( Math.pow(2.0, index.toDouble())  * i).toInt() }
        return sum
    }
}