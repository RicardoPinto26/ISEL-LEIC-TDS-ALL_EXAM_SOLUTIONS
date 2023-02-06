import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Score(val name:String, var rating:Int) {
    init {
        check(rating in 1 ..MAX_RATING)
    }
}

fun List<Score>.replace(score:Score):List<Score>{
    val originalScore = this.filter{it.name == score.name}
    return this-originalScore+score
}