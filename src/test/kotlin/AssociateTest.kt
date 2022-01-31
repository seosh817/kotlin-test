import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class AssociateTest {

    private lateinit var personList: List<Person>

    @BeforeEach
    internal fun setUp() {
        personList = listOf(Person("abc", 1), Person("def", 1), Person("ghi", 2), Person("jkl", 3), Person("mno", 3))
    }

    @Test
    fun `associate() 테스트`() {
        val associateMap: Map<String, Int> = personList.associate { it.name to it.age }
        println(associateMap) // {abc=1, def=1, ghi=2, jkl=3, mno=3}
    }

    @Test
    fun `associateBy() 테스트`() {
        val associateMap: Map<String, Person> = personList.associateBy { it.name }
        println(associateMap) // {abc=Person(name=abc, age=1), def=Person(name=def, age=1), ghi=Person(name=ghi, age=2), jkl=Person(name=jkl, age=3), mno=Person(name=mno, age=3)}
    }

    @Test
    fun `associateWith() 테스트`() {
        val associateMap: Map<Person, String> = personList.associateWith { it.name }
        println(associateMap) // {Person(name=abc, age=1)=abc, Person(name=def, age=1)=def, Person(name=ghi, age=2)=ghi, Person(name=jkl, age=3)=jkl, Person(name=mno, age=3)=mno}
    }
}