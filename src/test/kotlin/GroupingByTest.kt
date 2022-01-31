import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GroupingByTest {

    private lateinit var grouping: Grouping<Int, Int>

    @BeforeEach
    internal fun setUp() {
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
        grouping = list.groupingBy { it % 3 }
    }

    @Test
    fun `groupingKeyOf() 테스트`() {
        val value2 = grouping.keyOf(2)
        assertThat(value2).isEqualTo(2)
    }

    @Test
    fun `aggregate() 테스트`() {
        val aggregated = grouping
            .aggregate { key, accumulator: Int?, element, first ->
                println("key: $key, accumulator: $accumulator, element: $element, first: $first")
                if (first) element else accumulator?.plus(element)
            }
        println(aggregated) // {0=9, 1=12, 2=15}
    }

    @Test
    fun `aggregate() 테스트2`() {
        val aggregated = grouping.aggregate { key, accumulator: StringBuilder?, element, first ->
            println("key: $key, accumulator: $accumulator, element: $element, first: $first")
            if (first) // first element
                StringBuilder().append(key).append(":").append(element)
            else
                accumulator!!.append("-").append(element)
        }
        println(aggregated.values) // [0:0-3-6, 1:1-4-7, 2:2-5-8]
    }

    @Test
    fun `fold() 테스트`() {
        val fold = grouping.fold(0) { accumulator, element ->
            accumulator + element
        }
        println(fold) // {0=9, 1=12, 2=15}
    }

    @Test
    fun `reduce() 테스트`() {
        val reduce = grouping.reduce { _, accumulator, element ->
            accumulator + element
        }
        println(reduce) // {0=9, 1=12, 2=15}
    }

    @Test
    fun `eachCount() 테스트`() {
        val eachCount = grouping.eachCount()
        println(eachCount) // {0=3, 1=3, 2=3}
    }
}
