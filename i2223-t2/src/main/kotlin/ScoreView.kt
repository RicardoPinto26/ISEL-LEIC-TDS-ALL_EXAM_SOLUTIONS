import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*

@Composable
fun ScoreView(src:List<Score>,maxRating:Int){
    var curScores by remember { mutableStateOf(src) }
    var selectedScore by remember { mutableStateOf<Score?>(null) }

    Row() {
        ScoreStars(
            score = selectedScore,
            max = maxRating,
            onChange = {
                curScores = curScores.replace(it)
                selectedScore = it
            }
        )

        ScoreList(
            values = curScores,
            onSelect = {
                selectedScore = it
            }
        )
    }
}
