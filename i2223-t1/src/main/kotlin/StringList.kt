import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun StringList(list: List<String>) {
    Column(Modifier.background(Color.Gray)) {
        list.forEach {
            Text(it)
        }
    }
}