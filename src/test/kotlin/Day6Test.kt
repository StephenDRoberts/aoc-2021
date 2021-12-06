import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day6Test {
    private val day6 = Day6()

    @Nested
    inner class Part1 {
        @Test
        fun `should return 26 for part 1 example after 18 days`() {
            val actual = day6.findSolution1("inputs6Example.txt", 18)

            assertThat(actual).isEqualTo(26)
        }

        @Test
        fun `should return 5934 for part 1 example after 80 days`() {
            val actual = day6.findSolution1("inputs6Example.txt", 80)

            assertThat(actual).isEqualTo(5934)
        }

        @Test
        fun `should return 361169 for part 1 main after 80 days`() {
            val actual = day6.findSolution1("inputs6.txt", 80)

            assertThat(actual).isEqualTo(361169)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `should return 5934 for part 1 example after 80 days using part2 method`() {
            val actual = day6.findSolution2("inputs6Example.txt", 80)

            assertThat(actual).isEqualTo(5934)
        }

        @Test
        fun `should return 26984457539 for part 1 example after 256 days`() {
            val actual = day6.findSolution2("inputs6Example.txt", 256)

            assertThat(actual).isEqualTo(26984457539)
        }

        @Test
        fun `should return 1634946868992 for part 2 main after 256 days`() {
            val actual = day6.findSolution2("inputs6.txt", 256)

            assertThat(actual).isEqualTo(1634946868992)
        }
    }

    @Nested
    inner class HelperFunctions {

    }
}