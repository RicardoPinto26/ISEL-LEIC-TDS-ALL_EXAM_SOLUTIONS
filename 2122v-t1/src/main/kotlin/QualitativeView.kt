import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun QualitativeView(selected: QualitativeGrade) =
    Text(selected.description,
        textAlign= TextAlign.Center,
        style= MaterialTheme.typography.h4
    )
