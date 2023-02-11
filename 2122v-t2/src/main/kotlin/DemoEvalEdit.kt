import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun DemoEvalEdit(grade: Grade, onValueChange: (Double) -> Unit) {
    var eval by remember {mutableStateOf(Eval.default)}
    Column {
        EvalEdit(eval) {
            eval = it
            onValueChange(grade.partialValue(eval))
        }
        Text("of ${grade.value} values = ${grade.partialValue(eval)}")
    }

}