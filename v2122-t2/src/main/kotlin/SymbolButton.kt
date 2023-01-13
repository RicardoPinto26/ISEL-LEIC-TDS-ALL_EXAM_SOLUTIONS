import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SymbolButton(symbol: Char, enabled: Boolean, onClick: () -> Unit) {
    Button(onClick = onClick, enabled = enabled) {
        Text("$symbol")
    }
}