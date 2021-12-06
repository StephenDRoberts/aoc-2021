import utils.Utils.readFileLinesAsStrings

class Day6 {
    private val prefix = "/Users/Stephen.Roberts2/Documents/001_Code/aoc2021/src/main/inputs/"

    fun findSolution1(inputPuzzle: String, days: Int): Int {
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath)
        val arrayInputs = inputs.first().split(",").map { it.toLong() }.toMutableList()

        val finalList = recuriveCheck(arrayInputs, 1, days)
        return finalList.count()
    }

    fun recuriveCheck(inputsList: MutableList<Long>, day: Int, dayLimit: Int): List<Long> {
        return if (day == dayLimit + 1) inputsList else {
            var newToAdd = 0
            var newList = inputsList.map { age ->
                var newAge = age - 1
                    if (newAge < 0) {
                        newToAdd++
                        newAge = 6
                    }
                    newAge
            }.toMutableList()
            for (i in 0 until newToAdd) {
                newList.add(8)
            }
            return recuriveCheck(newList, day + 1, dayLimit)
        }
    }

    fun findSolution2(inputPuzzle: String, dayLimit: Int): Long{
        val filepath = "${prefix}${inputPuzzle}"
        val inputs = readFileLinesAsStrings(filepath)
        val mutableList = mutableListOf<Long>(0,0,0,0,0,0,0,0,0)
        inputs.first()
            .split(",")
            .groupingBy { it }
            .eachCount()
            .entries.map { name -> mutableList[name.key.toInt()] = name.value.toLong()}

        val solvedArray = recursiveArray(mutableList, 1, dayLimit)

        return solvedArray.sum()
    }

    fun recursiveArray(list: List<Long>, day: Int, dayLimit: Int): List<Long>{
        if(day == dayLimit + 1) return list else {
            var newList = mutableListOf<Long>(0,0,0,0,0,0,0,0,0)
              for(i in 0..7){
                  newList[i] = list[i+1]
            }
            newList[8] = list[0]
            newList[6] += list[0]
            return recursiveArray(newList, day +1, dayLimit)
        }
    }
}

