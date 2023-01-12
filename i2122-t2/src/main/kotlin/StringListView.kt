import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

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