import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class TemplateTest {
    private val day9 = Day9()

    @Nested
    inner class Part1 {
        @Test
        fun `should return xx for part 1 example input`() {
            val actual = day9.findSolution1("inputs9Example.txt")

            assertThat(actual).isEqualTo(15)
        }
    }

    @Nested
    inner class Part2 {

    }
}