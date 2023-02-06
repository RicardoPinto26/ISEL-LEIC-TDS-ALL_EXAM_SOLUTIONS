import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import org.w3c.dom.Text

@Composable
fun ScoreStars(score:Score?, max:Int, onChange: (Score)->Unit) {
    Column(){
        Stars(
            rating = score?.rating ?: 0,
            max = max,
            onChange = {
                if (score != null)
                    onChange(
                        Score(
                            name=score.name,
                            rating = it
                        )
                    )
            }
        )
        Text(score?.name ?: "",
            style = MaterialTheme.typography.h2,
        )
    }
}