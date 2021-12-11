import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day10Test {
    private val day10 = Day10()

    @Nested
    inner class Part1 {
        @Test
        fun `should return 26397 for part 1 example input`() {
            val actual = day10.findSolution1("inputs10Example.txt")

            assertThat(actual).isEqualTo(26397)
        }

        @Test
        fun `should return 392139 for part 1 main input`() {
            val actual = day10.findSolution1("inputs10.txt")

            assertThat(actual).isEqualTo(392139)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `should return 288957 for part 2 example input`() {
            val actual = day10.findSolution2("inputs10Example.txt")

            assertThat(actual).isEqualTo(288957)
        }

        @Test
        fun `should return 4001832844 for part 2 main input`() {
            val actual = day10.findSolution2("inputs10.txt")

            assertThat(actual).isEqualTo(4001832844)
        }
    }
}