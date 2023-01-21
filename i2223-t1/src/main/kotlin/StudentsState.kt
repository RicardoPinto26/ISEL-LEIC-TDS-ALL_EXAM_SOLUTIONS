import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class StudentsState(var students: List<Student>) {
    var viewStudents: List<Student> by mutableStateOf(students)

    fun add(fields: List<String>) {
        students = students.filter { it.number != fields[0].toInt() } + Student(
            fields[0].toInt(),
            fields[1],
            fields[2].toInt()
        )
        viewStudents = students
    }

    fun filter(fields: List<String>) {
        val numberOK = fields[0].isEmpty() || fields[0].any { !it.isDigit() }
        val classOK = fields[1].isEmpty()
        val groupOK = fields[2].isEmpty() || fields[0].any { !it.isDigit() }

        viewStudents = students.filter {
            (numberOK || it.number == fields[0].toInt()) &&
            (classOK || it.classId == fields[1]) &&
            (groupOK || it.group == fields[2].toInt())
        }
    }
}