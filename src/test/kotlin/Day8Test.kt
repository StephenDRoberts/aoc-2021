import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day8Test {
    private val day8 = Day8()

    @Nested
    inner class Part1 {
        @Test
        fun `should return 26 for part 1 example input`(){
            val actual = day8.findSolution1("inputs8Example.txt")

            assertThat(actual).isEqualTo(26)
        }

        @Test
        fun `should return 452 for part 1 main input`(){
            val actual = day8.findSolution1("inputs8.txt")

            assertThat(actual).isEqualTo(452)
        }
    }

    @Nested
    inner class Part2 {
        @Test
        fun `should return 61229 for part 1 example input`(){
            val actual = day8.findSolution2("inputs8Example.txt")

            assertThat(actual).isEqualTo(61229)
        }

        @Test
        fun `should return 1096964 for part 1 main input`(){
            val actual = day8.findSolution2("inputs8.txt")

            assertThat(actual).isEqualTo(1096964)
        }
    }
}