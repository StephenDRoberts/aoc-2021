import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day9Test {
    private val day9 = Day9()

    @Nested
    inner class Part1 {
        @Test
        fun `should return 26 for part 1 example input`(){
            val actual = day9.findSolution1("inputs9Example.txt")

            assertThat(actual).isEqualTo(15)
        }

        @Test
        fun `should return 524 for part 1 main input`(){
            val actual = day9.findSolution1("inputs9.txt")

            assertThat(actual).isEqualTo(524)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `should return 1134 for part 2 example input`(){
            val actual = day9.findSolution2("inputs9Example.txt")

            assertThat(actual).isEqualTo(1134)
        }

        @Test
        fun `should return 1134 for part 2 main input`(){
            val actual = day9.findSolution2("inputs9.txt")

            assertThat(actual).isEqualTo(1134)
        }
    }
}