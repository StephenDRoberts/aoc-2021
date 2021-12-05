import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day5Test {
    private val day5 = Day5()

    @Nested
    inner class Part1 {

        @Test
        fun `should return 5 for part 1 example input`() {
            val actual = day5.findSolution1("inputs5Example.txt")

            assertThat(actual).isEqualTo(5)
        }

        @Test
        fun `should return 6113 for part 1 main input`() {
            val actual = day5.findSolution1("inputs5.txt")

            assertThat(actual).isEqualTo(6113)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `should return 12 for part 2 example input`() {
            val actual = day5.findSolution2("inputs5Example.txt")

            assertThat(actual).isEqualTo(12)
        }

        @Test
        fun `should return 20373 for part 2 main input`() {
            val actual = day5.findSolution2("inputs5.txt")

            assertThat(actual).isEqualTo(20373)
        }
    }

    @Nested
    inner class HelperFunctions {
        @Test
        fun `should reduce line to pair of co-ordinates`(){
            val line = "0,9 -> 5,9"
            val expStart = Pair(0,9)
            val expEnd = Pair(5,9)
            val expected = Pair(expStart, expEnd)

            val actual = day5.convertLineToStartAndEndCoords(line)

            assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `should remove diagonals`(){
            val startAndEnd1 = Pair(Pair(0,9), Pair(5,9))
            val startAndEnd2 = Pair(Pair(8,0), Pair(0,8))

            val actual = day5.filterIfDiagonal(listOf(startAndEnd1, startAndEnd2))

            assertThat(actual).isEqualTo(listOf(startAndEnd1))
        }

        @Test
        fun `should plot out a path for start and end coordinates`(){
            val startAndEnd1 = Pair(Pair(0,9), Pair(3,9))
            val expected = listOf(Pair(0,9), Pair(1,9), Pair(2,9), Pair(3,9))

            val actual = day5.plotOutSingleStartAndEnd(startAndEnd1)

            assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `should plot out a path for start and end coordinates going backwards`(){
            val startAndEnd1 = Pair(Pair(7,4), Pair(3,4))
            val expected = listOf(Pair(7,4), Pair(6,4), Pair(5,4), Pair(4,4), Pair(3,4)).reversed()

            val actual = day5.plotOutSingleStartAndEnd(startAndEnd1)

            assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `should plot out a path for start and end coordinates for diagonals`(){
            val startAndEnd1 = Pair(Pair(7,9), Pair(9,7))
            val expected = listOf(Pair(7,9), Pair(8,8), Pair(9,7))

            val actual = day5.plotOutSingleStartAndEndForDiagonals(startAndEnd1)

            assertThat(actual).isEqualTo(expected)
        }
    }
}