import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day7Test {
    private val day7 = Day7()

    @Nested
    inner class Part1 {
        @Test
        fun `should return 37 for part 1 example input`(){
            val actual = day7.findSolution1("inputs7Example.txt")

            assertThat(actual).isEqualTo(37)
        }

        @Test
        fun `should return 336131 for part 1 main input`() {
            val actual = day7.findSolution1("inputs7.txt")

            assertThat(actual).isEqualTo(336131)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `should return 168 for part 2 example input`(){
            val actual = day7.findSolution2("inputs7Example.txt")

            assertThat(actual).isEqualTo(168)
        }
        @Test
        fun `should return 92676646 for part 2 main input`(){
            val actual = day7.findSolution2("inputs7.txt")

            assertThat(actual).isEqualTo(92676646)
        }
    }
}