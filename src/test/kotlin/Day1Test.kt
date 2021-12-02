import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1Test() {
    private val day1 = Day1()

    @Test
    fun `should return 7 for test input 1 puzzle`(){
        val file = "inputs1Example.txt"
        val actual = day1.findSolution1(file)

        assertThat(actual).isEqualTo(7)
    }

    @Test
    fun `should return 1475 for input 1 puzzle`(){
        val file = "inputs1.txt"
        val actual = day1.findSolution1(file)

        assertThat(actual).isEqualTo(1475)
    }

    @Test
    fun `should return 5 for test input 2 puzzle`(){
        val file = "inputs1Example.txt"
        val actual = day1.findSolution2(file)

        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `should return 1516 for input 2 puzzle`(){
        val file = "inputs1.txt"
        val actual = day1.findSolution2(file)

        assertThat(actual).isEqualTo(1516)
    }
}