package blackjack

import org.junit.jupiter.api.Test

class CollectionTest {

    @Test
    fun flatMapTest() {
        val ints = (1..4) // [1, 2, 3, 4]
        val strings = listOf("a", "b", "c", "d")

        val flatMapList = ints.flatMap { int ->
            strings.map { string ->
                "$int$string"
            }
        }
        println(flatMapList)
    }

    @Test
    fun flatMapTest2() {
        val list = listOf(listOf(1,2,3), listOf(4, 5, 6), listOf(7, 8, 9))

        val flatMap = list.flatMap { it }
        val flatten = list.flatten()
        println(flatten)
    }
}