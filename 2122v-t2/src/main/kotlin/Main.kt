import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication

fun main() = singleWindowApplication(
    title = "Quotation Demo",
    state = WindowState(width = 280.dp, height = 130.dp),
) {
    MaterialTheme {
        DemoEvalEdit(Grade(4)) { partial: Double ->
            println("Partial = ${partial.format(2)}")
        }
    }
}

fun Double.format(digs: Int) = "%.${digs}f".format(this)
