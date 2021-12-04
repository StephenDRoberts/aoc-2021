package utils

import org.springframework.stereotype.Component
import java.io.File

@Component
object Utils {

    fun readFileLinesAsInts(fileName: String): List<Int> {
        val list = mutableListOf<Int>()
        File(fileName).forEachLine { list.add(it.toInt()) }
        return list
    }

    fun readFileLinesAsStrings(fileName: String): List<String> {
        val list = mutableListOf<String>()
        File(fileName).forEachLine { list.add(it) }
       return list
    }

    fun readFileLinesAsStringsWithDelimiter(fileName: String, delimiter: String): List<List<String>> {
        val list = mutableListOf<List<String>>()
        File(fileName).forEachLine { list.add(it.split(delimiter)) }
        return list
    }

    fun readFileLinesAsPairsOfStrings(fileName: String, delimiter: String): List<Pair<String, String>> {
        val list = mutableListOf<Pair<String, String>>()
        File(fileName).forEachLine { it ->
            val splitLine = it.split(delimiter)
            list.add(Pair(splitLine[0], splitLine[1]))
        }
        return list
    }


}