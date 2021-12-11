import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day11Test {
    private val day11 = Day11()

    @Nested
    inner class Part1 {
        @Test
        fun `should return 1656 for part 1 example input`() {
            val actual = day11.findSolution1("inputs11Example.txt")

            assertThat(actual).isEqualTo(1656)
        }

        @Test
        fun `should return 1656 for part 1 main input`() {
            val actual = day11.findSolution1("inputs11.txt")

            assertThat(actual).isEqualTo(1656)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `should return 195 for part 2 example input`() {
            val actual = day11.findSolution2("inputs11Example.txt")

            assertThat(actual).isEqualTo(195)
        }

        @Test
        fun `should return 195 for part 2 main input`() {
            val actual = day11.findSolution2("inputs11.txt")

            assertThat(actual).isEqualTo(195)
        }
    }
}