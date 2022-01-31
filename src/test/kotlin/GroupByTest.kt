import org.junit.jupiter.api.Test

data class Person(val name: String, val age: Int)

class GroupByTest {

    @Test
    fun `groupBy() 테스트1`() {
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
        val groupByMap: Map<Int, List<Int>> = list.groupBy { it % 2 }
        println(groupByMap) // {0=[0, 2, 4, 6, 8], 1=[1, 3, 5, 7]}
    }

    @Test
    fun `groupBy() 테스트2`() {
        val personList = listOf(Person("abc", 1), Person("def", 1), Person("ghi", 2), Person("jk", 3))
        val personGroupByMap: Map<Int, List<Person>> = personList.groupBy { it.age }
        println(personGroupByMap)
    }
}