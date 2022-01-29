package blackjack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@JvmInline
value class CopyMap private constructor(private val _map: MutableMap<String, String>) {

    private val map: Map<String, String>
        get() = _map.toMap()

    fun getValue(key: String): String {
        return map[key] ?: throw NullPointerException("is null")
    }

    fun setValue(key: String, value: String) {
        _map[key] = value
    }

    companion object {
        fun from(map: Map<String, String>): CopyMap = CopyMap(map.toMutableMap())
    }
}


class MapCopyTest {

    @Test
    fun `카피 테스트`() {
        val copyMap = CopyMap.from(mapOf("abc" to "def"))

        val value = copyMap.getValue("abc")

        assertThat(value).isEqualTo("def")
    }
}
