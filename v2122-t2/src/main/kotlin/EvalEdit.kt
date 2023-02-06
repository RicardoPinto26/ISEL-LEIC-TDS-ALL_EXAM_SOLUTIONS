import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun EvalEdit(eval: Eval, set: (Eval) -> Unit) {
    Row(modifier = Modifier
        .width(200.dp)
        .height(60.dp)
        .border(border = BorderStroke(width = 1.dp, Color.LightGray)))
    {
        SymbolButton('-', eval.quotation != Eval.MIN,
            onClick = {
                set(eval.dec())
            }
        )
        TextField(
            modifier = Modifier.background(Color.LightGray)
                .width(40.dp)
                .height(20.dp)
                .align(Alignment.CenterVertically),
            value = "${eval.quotation}",
            onValueChange = {
                val value = it.toInt()
                if (value in (Eval.MIN..Eval.MAX step Eval.DELTA)) set(Eval.of(value) ?: eval)
            }
        )
        Text("%")
        SymbolButton('+', eval.quotation != Eval.MAX,
            onClick = {
                set(eval.inc())
            }
        )
    }
}