import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    val state = WindowState(size = DpSize(600.dp, Dp.Unspecified))
    Window(onCloseRequest = ::exitApplication, state = state, title = "Grades Converter") {
        var converter by remember { mutableStateOf(GradeConverter(10.grade)) }
        Column(Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            GradeSelector(converter.quantitative) { sel: Grade ->
                converter = GradeConverter(sel)
            }
            QualitativeView(converter.qualitative)
        }
    }
}
