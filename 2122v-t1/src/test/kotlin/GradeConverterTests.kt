import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class GradeConverterTests {
    @Test
    fun converterOK() {
        val sut = GradeConverter(19.grade)
        assertEquals(19, sut.quantitative.value)
        assertEquals("Muito Bom", sut.qualitative.description)
    }

    @Test
    fun converterError() {
        assertFailsWith<IllegalStateException> {
            GradeConverter((-3).grade)
        }
    }
}
