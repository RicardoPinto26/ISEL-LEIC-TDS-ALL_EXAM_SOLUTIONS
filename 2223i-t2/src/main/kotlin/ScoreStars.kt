import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ScoreStars(score: Score?, max: Int, onChange: (Score) -> Unit) {
    Column {
        Stars(
            rating = score?.rating ?: 0,
            max = max,
            onChange = {
                if (score != null)
                    onChange(
                        Score(
                            name = score.name,
                            rating = it
                        )
                    )
            }
        )
        Text(
            score?.name ?: "",
            style = MaterialTheme.typography.h2,
        )
    }
}
