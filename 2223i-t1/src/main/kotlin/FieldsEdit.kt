import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FieldsEdit(
    labels: List<String>,
    onAdd: (List<String>) -> Unit, onFilter: (List<String>) -> Unit
) {
    val fields = List(labels.size) { remember { mutableStateOf("") } }
    Column(
        modifier = Modifier.border(2.dp, Color.Gray).padding(5.dp).width(320.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            fields.forEachIndexed { i, f ->
                LabeledField(labels[i], f.value) { f.value = it }
            }
        }
        Row(
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onAdd(fields.map { it.value }) })
            { Text("Add") }
            Button(onClick = { onFilter(fields.map { it.value }) })
            { Text("Filter") }
        }
    }
}


@Composable
fun LabeledField(label: String, value: String, onChange: (String) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("$label:")
        TextField(value, onValueChange = onChange, modifier = Modifier.width(100.dp))
    }
}
