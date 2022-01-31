import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FoldReduceTest {

    @Test
    fun foldTest() {
        val intArray = intArrayOf(1, 2, 3)
        val foldValue = intArray.fold(0) { acc, num -> acc + num }
        assertThat(foldValue).isEqualTo(6)
    }

    @Test
    fun reduceTest() {
        val emptyList = emptyList<Int>()
        val reducedValue = emptyList.reduce { acc, num -> acc + num }
        assertThat(reducedValue).isEqualTo(6)
    }
}