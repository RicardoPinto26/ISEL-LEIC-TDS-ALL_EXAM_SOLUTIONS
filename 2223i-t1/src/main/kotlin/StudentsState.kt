import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class StudentsState(initialStudents: List<Student>) {
    private val allStudents = initialStudents.toMutableList()
    var viewStudents by mutableStateOf(initialStudents)
        private set

    fun add(fields: List<String>) {
        val student = Student(
            number = fields[0].toIntOrNull() ?: return,
            classId = fields[1].takeIf { it.isNotBlank() } ?: return,
            group = fields[2].toIntOrNull() ?: return
        )
        allStudents.removeIf { it.number == student.number }
        allStudents.add(student)
        viewStudents = allStudents
    }

    fun filter(fields: List<String>) {
        val number = fields[0].toIntOrNull()
        val classId = fields[1].takeIf { it.isNotBlank() }
        val group = fields[2].toIntOrNull()
        viewStudents = allStudents.filter {
            (number == null || it.number == number) &&
                    (classId == null || it.classId == classId) &&
                    (group == null || it.group == group)
        }
    }
}


