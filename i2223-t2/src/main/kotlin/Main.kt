import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

const val MAX_RATING = 3

data class Score(val name: String, val rating: Int) {
    init {
        require(rating in 1..MAX_RATING)
    }
}

fun List<Score>.replace(score: Score) = this.map {
    if (it.name == score.name) score
    else it
}

@Composable
fun ImageResource(resource: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier.clickable { onClick() }) {
        Image(painterResource(resource), resource)
    }
}

@Composable
fun Stars(rating: Int, max: Int, onChange: (Int) -> Unit) {
    Row {
        for (i in 1..rating) {
            Box {
                ImageResource("black_pawn.png", onClick = {
                    onChange(i)
                })
            }
        }

        for (i in rating + 1..max) {
            Box {
                ImageResource("white_pawn.png", onClick = {
                    onChange(i)
                })
            }
        }
    }
}

@Composable
fun ScoreStars(score: Score?, max: Int, onChange: (Score) -> Unit) {
    Column {
        Stars(score?.rating ?: 0, max) {
            if (score != null)
                onChange(
                    Score(
                        name = score.name,
                        rating = it
                    )
                )
        }
        if (score != null) {
            Text(score.name)
        }
    }
}

@Composable
fun ScoreList(values: List<Score>, onSelect: (Score) -> Unit) {
    Column {
        values.forEach {
            Row {
                Text(it.name)
                Button(onClick = { onSelect(it) }) {
                    Text("${it.rating}")
                }
            }
        }
    }
}

@Composable
fun ScoreView(src: List<Score>, maxRating: Int) {
    var scores by remember { mutableStateOf(src) }
    var currentScore by remember { mutableStateOf<Score?>(null) }

    Row {
        ScoreStars(currentScore, maxRating) {
            scores = scores.replace(it)
            currentScore = it
        }
        ScoreList(scores) {
            currentScore = it
        }
    }
}

fun main() {
    val movies: List<Score> =
        listOf(
            Score("Shining", 3),
            Score("Mass", 3),
            Score("Bambi", 3),
            Score("Avengers", 1)
        )
    application {
        //val winState = WindowState(width = 450.dp, height = 300.dp)
        Window(/*state = winState,*/ onCloseRequest = ::exitApplication, resizable = true, title = "Playlist") {
            ScoreView(movies, MAX_RATING)
        }
    }
}
