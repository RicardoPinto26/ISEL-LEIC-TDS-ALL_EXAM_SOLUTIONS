import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun ScoreList(values:List<Score>,onSelect:(Score)->Unit){
    Box(modifier = Modifier
        .border(BorderStroke(2.dp,SolidColor(Color.Gray)))
        .padding(20.dp)){
        Column(){
            values.forEach{ score ->
                Row(){
                    Text(score.name)
                    Button(
                        onClick = {onSelect(score)}
                    ){ Text("${score.rating}") }
                }
            }
        }
    }
}