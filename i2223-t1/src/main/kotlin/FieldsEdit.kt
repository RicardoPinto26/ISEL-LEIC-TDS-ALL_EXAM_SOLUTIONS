import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun FieldsEdit(labels: List<String>, onAdd: (List<String>) -> Unit, onFilter: (List<String>) -> Unit) {
    var numberField by remember { mutableStateOf("") }
    var classField by remember { mutableStateOf("") }
    var groupField by remember { mutableStateOf("") }

    Column {
        Row {
            LabeledField(labels[0], numberField) { numberField = it }
            LabeledField(labels[1], classField) { classField = it }
            LabeledField(labels[2], groupField) { groupField = it }
        }
        Row {
            Button(onClick = { onAdd(listOf(numberField, classField, groupField)) }) {
                Text("Add")
            }
            Button(onClick = { onFilter(listOf(numberField, classField, groupField)) }) {
                Text("Filter")
            }
        }
    }
}

@Composable
fun LabeledField(label: String, value: String, onChange: (String) -> Unit) {
    Column {
        Text(label)
        TextField(value, onValueChange = onChange)
    }
}