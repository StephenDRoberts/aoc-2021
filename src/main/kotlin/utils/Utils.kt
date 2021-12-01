package utils

import org.springframework.stereotype.Component
import java.io.File

@Component
object Utils {

    fun readFileLineByLineUsingForEachLine(fileName: String): List<Int> {
        val list = mutableListOf<Int>()
        File(fileName).forEachLine { it -> list.add(it.toInt()) }
        return list
    }
}