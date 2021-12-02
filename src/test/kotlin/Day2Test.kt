import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day2Test {
    private val day2 = Day2()

    @Test
    fun `should return 150 for part 1 example inputs`() {
        val file = "inputs2Example.txt"

        val actual = day2.findSolution1(file, " ")

        assertThat(actual).isEqualTo(150)
    }

    @Test
    fun `should return 1924923 for part 1 inputs`() {
        val file = "inputs2.txt"

        val actual = day2.findSolution1(file, " ")

        assertThat(actual).isEqualTo(1924923)
    }

    @Test
    fun `should return 900 for part 2 example inputs`() {
        val file = "inputs2Example.txt"

        val actual = day2.findSolution2(file, " ")

        assertThat(actual).isEqualTo(900)
    }

    @Test
    fun `should return 1982495697 for part 2 inputs`() {
        val file = "inputs2.txt"

        val actual = day2.findSolution2(file, " ")

        assertThat(actual).isEqualTo(1982495697)
    }
}