package edu.gr05513.trainer05_513.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.gr05513.trainer05_513.ui.theme.Trainer05513Theme

@Composable
fun ArithmeticCard(
    modifier: Modifier = Modifier,
){
    val task = "12 + 42 = "
    Card(modifier = modifier
        .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
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
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                    )
                )
            }
            IconButton(
                onClick = {

                },
                modifier = Modifier.padding(8.dp).border(1.dp, Color.Black, RoundedCornerShape(100))
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
        ArithmeticCard(Modifier.fillMaxWidth())
    }
}