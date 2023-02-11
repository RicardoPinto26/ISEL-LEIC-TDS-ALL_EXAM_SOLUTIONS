import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() {
    //val todoList = readFromFile("Todo.txt")
    application {
        val state = WindowState(width = 450.dp, height = 200.dp)
        val todo = remember { mutableStateOf(TodoList()) }
        Window(
            onCloseRequest = {
                //todo.value.writeToFile("Todo.txt")
                exitApplication()
            },
            state = state, title = "Todo List"
        ) {
            Row(Modifier.padding(5.dp)) {
                TaskNameEditor(
                    onAdd = { t: Task -> todo.value = todo.value.add(t) },
                    onRemove = { t: Task -> todo.value = todo.value.remove(t) }
                )

                StringListView(title = "Tasks:", values = todo.value.tasks.map { it.name })
            }
        }
    }
}
