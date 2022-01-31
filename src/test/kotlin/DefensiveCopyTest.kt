import org.junit.jupiter.api.Test

data class Car(val name: String = "", var position: Int = 0) {
    fun move() {
        position++
    }
}


@JvmInline
value class Cars private constructor(private val _cars: List<Car>) {
    val cars: List<Car>
        get() = _cars.map { it.copy() }

    companion object {
        fun from(carList: List<Car>): Cars {
            return Cars(carList.toList())
        }
    }
}

class DefensiveCopyTest {

    @Test
    fun moveTest() {
        val car = Car("car")
        val carList = mutableListOf(car) // [1159114532]
        val cars = Cars.from(carList) // [1256728724]
        println("address == ${carList.map { System.identityHashCode(it) }}, cars == ${carList}}") // address == [1159114532], cars == [Car(name=car, position=0)]}
        car.move()
        println("address == ${cars.cars.map { System.identityHashCode(it) }}, cars == ${cars.cars}") // address == [1256728724], cars == [Car(name=car, position=0)]
    }
}