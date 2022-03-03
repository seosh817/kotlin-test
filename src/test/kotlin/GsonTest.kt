import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import org.junit.jupiter.api.Test

data class ErrorBody(
    @SerializedName("request_status") val requestStatus: String,
    @SerializedName("request_status_reason") val requestStatusReason: Int,
    @SerializedName("request_status_reason_str") val requestStatusReasonStr: String
)

sealed class BaseException(
    requestStatusReason: Int
) : Exception(requestStatusReason.toString()) {

    class SomethingException(requestStatusReason: Int): BaseException(requestStatusReason)
    class UnknownException: BaseException(0)

    companion object {
        fun codeToException(code: Int): BaseException {
            return when (code) {
                2318 -> SomethingException(requestStatusReason = code)
                else -> UnknownException()
            }
        }
    }
}

inline fun <reified T> String.fromJson(gson: Gson = Gson()): T {
    val type = object : TypeToken<T>() {}.type
    return gson.fromJson(this, type)
}


class GsonTest {

    private val gson = Gson()
    private val jsonString =
        "{\"request_status\":\"FAIL\",\"request_status_reason\":2318,\"request_status_reason_str\":\"ERROR_CODE.ALREADY_REGSISTERED_OTHER_CMP_EQUIP\"}"

    @Test
    fun gsonTest() {
        val errorBody: ErrorBody = jsonString.fromJson(gson)
        println("errorBody == $errorBody")
    }
}