import org.junit.jupiter.api.Test

data class Person1(val position: Position)

data class Position(private val x: Int, val y: Int) : Comparable<Position> {

    override fun compareTo(other: Position): Int {
        return compareValuesBy(
            this, other,
            {
                it.y
            },
            {
                it.x
            },
        )
    }
}

class ComparableTest {

    @Test
    fun comparableTest() {
        val list = listOf(
            Person1(Position(0, 3)),
            Person1(Position(2, 2)),
            Person1(Position(1, 5)),
            Person1(Position(5, 1)),
            Person1(Position(4, 4)),
            Person1(Position(3, 0)),
        )

        val sortedList = list.sortedBy { it.position }

        1.compareTo(2)
        println(sortedList)
    }

}