import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun StringListView(title: String, values: List<String>) {
    Column {
        Text(title)
        Column {
            values.forEach {
                Text(it)
            }
        }
    }
}
