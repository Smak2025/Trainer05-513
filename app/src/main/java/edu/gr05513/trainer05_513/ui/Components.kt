package edu.gr05513.trainer05_513.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.gr05513.trainer05_513.R
import edu.gr05513.trainer05_513.model.CardData
import edu.gr05513.trainer05_513.ui.theme.Trainer05513Theme
import kotlin.math.absoluteValue

@Composable
fun ArithmeticCard(
    data: CardData,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onAnswer: (Int?)->Unit = {},
){
    val task = buildString {
        append(data.value1)
        append(" ")
        append(data.operation.symbol)
        append(" ")
        if (data.value2 < 0) append("(")
        append(data.value2)
        if (data.value2 < 0) append(")")
        append(" = ")
    }
    var userValue by remember { mutableStateOf("") }
    Card(modifier = modifier
        .border(1.dp, Color.Black, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = when(data.isCorrect.also { println(it) }){
            true -> Color(200, 255, 200, 180)
            false -> Color(255, 200, 200, 180)
            null -> Color(180, 180, 180, 180)
        })
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    task,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 44.sp
                )
                OutlinedTextField(
                    value = userValue,
                    onValueChange = {
                        if (it == ""
                            || it == "-"
                            || (it.toIntOrNull() != null && it.toInt().absoluteValue <= 100) ){
                            userValue = it
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                    ),
                    textStyle = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                    enabled = enabled
                )
            }
            IconButton(
                onClick = {
                    onAnswer(userValue.toIntOrNull())
                },
                modifier = Modifier
                    .padding(8.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(100)),
                enabled = enabled
            ) {
                Icon(Icons.Default.Done, null, tint = Color.Blue)
            }
        }
    }
}

@Composable
@Preview
fun ArithmeticCardPreview(){
    Trainer05513Theme {
        ArithmeticCard(
            CardData(),
            Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun Results(
    cards: List<CardData>,
    modifier: Modifier = Modifier,
    onClose: ()->Unit = {},
){
    AlertDialog(
        onDismissRequest = onClose,
        confirmButton = {
            OutlinedButton(onClick = onClose) {
                Text(stringResource(R.string.results_button_retest))
            }
        },
        title = {
            Text(stringResource(R.string.results_title))
        },
        text = {
            Text(
                stringResource(
                    R.string.results_text,
                    cards.count { it.isCorrect == true },
                    cards.size
                ))
        },
        modifier = modifier,
    )
}

@Composable
@Preview
fun ResultsPreview(){
    Trainer05513Theme {
        val cards = listOf(CardData(), CardData(), CardData(), CardData(), CardData())
        cards[0].userResult = cards[0].result
        cards[1].userResult = cards[1].result
        cards[2].userResult = 0
        cards[3].userResult = 2
        cards[4].userResult = cards[4].result
        Results(
            cards,
        )
    }
}
