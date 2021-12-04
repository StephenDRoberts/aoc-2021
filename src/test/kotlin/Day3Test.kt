import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day3Test {
    private val day3 = Day3()

    @Test
    fun `should return 198 for test day3 puzzle 1 example input`(){
        val file = "inputs3Example.txt"
        val actual = day3.findSolution1(file)

        assertThat(actual).isEqualTo(198)
    }

    @Test
    fun `should return 230 for test day3 puzzle 2 example input`(){
        val file = "inputs3Example.txt"
        val actual = day3.findSolution2(file)

        assertThat(actual).isEqualTo(230)
    }

    @Test
    fun `should return 2743844 for test day3 puzzle 1 input`() {
        val file = "inputs3.txt"
        val actual = day3.findSolution1(file)

        assertThat(actual).isEqualTo(2743844)
    }

    @Test
    fun `should return 6677951 for test day3 puzzle 2 example input`(){
        val file = "inputs3.txt"
        val actual = day3.findSolution2(file)

        assertThat(actual).isEqualTo(6677951)
    }

    @Test
    fun `should convert 00100 to 4`() {
        val actual = day3.convertBinaryToDecimal(listOf(0,0,1,0,0))
        assertThat(actual).isEqualTo(4)
    }

    @Test
    fun `should convert 10110 to 22`() {
        val actual = day3.convertBinaryToDecimal(listOf(1,0,1,1,0))
        assertThat(actual).isEqualTo(22)
    }

    @Test
    fun `should convert 011111101011 to 2027`() {
        val actual = day3.convertBinaryToDecimal(listOf(0,1,1,1,1,1,1,0,1,0,1,1))
        assertThat(actual).isEqualTo(2027)
    }
}