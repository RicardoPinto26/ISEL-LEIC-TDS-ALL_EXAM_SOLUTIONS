import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun TaskNameEditor(onAdd: (Task) -> Unit, onRemove: (Task) -> Unit) {
    var text by remember { mutableStateOf("") }
    Column {
        TextField(
            value = text,
            onValueChange = { input ->
                text = input
            }
        )
        Button(enabled = text.canBeTask(), onClick = { onAdd(Task(text)) }) {
            Text("Add")
        }

        Button(enabled = text.canBeTask(), onClick = { onRemove(Task(text)) }) {
            Text("Remove")
        }
    }
}