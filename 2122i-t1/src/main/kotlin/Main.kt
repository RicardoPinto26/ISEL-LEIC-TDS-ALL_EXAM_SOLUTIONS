import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    MaterialTheme {
        val state = WindowState(width = 250.dp, height = Dp.Unspecified)
        Window(onCloseRequest = ::exitApplication, state = state, title = "Occupancy") {
            MainContent()
        }
    }
}
