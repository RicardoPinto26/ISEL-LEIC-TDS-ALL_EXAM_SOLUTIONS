import kotlin.test.Test
import kotlin.test.assertEquals

class StudentsStateTests {
    @Test
    fun test_StudentsState_Add() {
        val students = listOf("50111 11D 3","50222 11D 3")
        val sut = StudentsState(students.map{ it.split(' ').toStudent() })
        sut.add(listOf("50333","11N","1"))
        val res = sut.viewStudents.map { it.toString() }
        assertEquals(students + "50333 11N 1", res)
    }

}