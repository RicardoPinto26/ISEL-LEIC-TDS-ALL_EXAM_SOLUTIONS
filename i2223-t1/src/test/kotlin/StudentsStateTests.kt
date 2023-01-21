import kotlin.test.Test
import kotlin.test.assertEquals

class StudentsStateTests {
    @Test
    fun `check correct add`() {
        val number = 47673; val classId = "32D"; val group = 3
        val studentString = listOf(number.toString(),classId,group.toString())
        val student = Student(number, classId, group)
        val ss = StudentsState(emptyList())

        ss.add(studentString)

        assertEquals(1, ss.students.size)
        assertEquals(student, ss.students.last())
    }
}