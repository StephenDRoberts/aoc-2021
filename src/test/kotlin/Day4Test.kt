import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day4Test {
    private val day4 = Day4()

    @Nested
    inner class Part1 {

        @Test
        fun `should return 4512 for part 1 example input`() {
            val actual = day4.findSolution1("inputs4Example.txt")

            assertThat(actual).isEqualTo(4512)
        }

        @Test
        fun `should return 82440 for part 1 input`() {
            val actual = day4.findSolution1("inputs4.txt")

            assertThat(actual).isEqualTo(82440)
        }
    }

    @Nested
    inner class Part2 {

        @Test
        fun `should return 1924 for part 1 example input`() {
            val actual = day4.findSolution2("inputs4Example.txt")

            assertThat(actual).isEqualTo(1924)
        }

        @Test
        fun `should return 20774 for part 1 input`() {
            val actual = day4.findSolution2("inputs4.txt")

            assertThat(actual).isEqualTo(20774)
        }
    }

    @Nested
    inner class HelperFunctions {

        @Test
        fun `should return 11 (0-index) for the max index of the row 14, 21, 17, 24 4`() {
            val inputDraw = listOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
            val row = listOf(14, 21, 17, 24, 4)

            val actual = day4.maxIndexOfRowAgainstDraw(row, inputDraw)

            assertThat(actual).isEqualTo(11)
        }

        @Test
        fun `should return 11 (0-index) for the min index of the GameCard3`() {
            val inputDraw = listOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
            val row1 = listOf(14, 21, 17, 24, 4)
            val row2 = listOf(10, 16, 15, 9, 19)
            val row3 = listOf(18, 8, 23, 26, 20)
            val row4 = listOf(22, 11, 13, 6, 5)
            val row5 = listOf(2, 0, 12, 3, 7)
            val gameCard = listOf(row1, row2, row3, row4, row5)

            val actual = day4.minIndexOfGameCard(gameCard, inputDraw)

            assertThat(actual).isEqualTo(11)
        }

        @Test
        fun `should transform columns to rows`(){
            val row1 = listOf(1,2,3)
            val row2 = listOf(4,5,6)
            val row3 = listOf(7,8,9)
            val inputs = listOf(row1, row2, row3)

            val row1Expected = listOf(1,4,7)
            val row2Expected = listOf(2,5,8)
            val row3Expected = listOf(3,6,9)
            val expected = listOf(row1Expected, row2Expected, row3Expected)

            val actual = day4.transposeRowsToColumns(inputs)
            assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `should remove called numbers and return flattened list`(){
            val row1 = listOf(1,2,3)
            val row2 = listOf(4,5,6)
            val row3 = listOf(7,8,9)
            val inputs = listOf(row1, row2, row3)

            val drawnNumbers = listOf(1,2,3,4,5,6,7)
            val expected = listOf(8,9)

            val actual = day4.removeCalledElements(inputs, drawnNumbers)
            assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `should reduce list of ints to sum`(){
            val row1 = listOf(1,2,3)
            val expected = 6

            val actual = day4.reduceToSum(row1)
            assertThat(actual).isEqualTo(expected)
        }

    }
}