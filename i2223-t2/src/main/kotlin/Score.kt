import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Score(val name:String, var rating:Int) {
    init {
        check(rating in 1 ..MAX_RATING)
    }
}

fun List<Score>.replace(score:Score):List<Score> = this.map { if(it.name==score.name)score else it }