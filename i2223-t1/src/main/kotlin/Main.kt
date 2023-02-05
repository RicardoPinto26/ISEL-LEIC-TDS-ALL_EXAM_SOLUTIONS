import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() {
    val allStudents: List<Student> =
        listOf(
            "50470 11D 4",
            "48325 11D 4",
            "12345 12D 5",
            "54321 31D 1",
            "47673 31D 3",
        ).map { it.split(' ').toStudent() }
    application {
        val winState = WindowState(width = 450.dp, height = 300.dp)
        val state = remember { StudentsState(allStudents) }
        Window(onCloseRequest = ::exitApplication, resizable = true,/*state = winState,*/ title = "Students") {
            Row(Modifier.padding(5.dp)) {
                FieldsEdit(
                    labels = listOf("Number", "Class", "Group"),
                    onAdd = { fields: List<String> -> state.add(fields) },
                    onFilter = { fields: List<String> -> state.filter(fields) }
                )
                StringList(state.viewStudents.map { it.toString() })
            }
        }
    }
}