import org.joda.time.DateTime
import org.junit.jupiter.api.Test
import java.text.DateFormatSymbols
import java.util.Calendar
import java.util.GregorianCalendar

class GregorianCalendarTest {


    @Test
    fun gregorianCalendarTest() {
        val gregorianCalendar = GregorianCalendar().apply { timeInMillis = DateTime.now().millis }
        val shortWeekDays = DateFormatSymbols.getInstance().shortWeekdays
        shortWeekDays.indices.forEach {
            print(shortWeekDays[it] + " ")
        }
        println()
        val dayOfWeek = gregorianCalendar.get(Calendar.DAY_OF_WEEK)
        println(dayOfWeek)
    }
}