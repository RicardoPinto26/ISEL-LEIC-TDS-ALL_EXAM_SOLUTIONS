import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GradeSelector(selected: Grade, onSelect: (Grade) -> Unit) =
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Grade.scale.forEach { g ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RadioButton(g == selected, modifier = Modifier.size(25.dp), onClick = { onSelect(g) })
                Text(g.value.toString())
            }
        }
    }
