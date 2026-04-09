package edu.gr05513.trainer05_513

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.gr05513.trainer05_513.ui.ArithmeticCard
import edu.gr05513.trainer05_513.ui.Results
import edu.gr05513.trainer05_513.ui.theme.Trainer05513Theme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Trainer05513Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (viewModel.showResults){
                        Results(viewModel.cards, Modifier.fillMaxWidth().padding(8.dp)){
                            viewModel.generateCards()
                            viewModel.showResults = false
                        }
                    }
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top)
                    ){
                        items(viewModel.cards.slice(0..viewModel.currentCard)){ card ->
                            ArithmeticCard(
                                card,
                                Modifier.padding(horizontal = 8.dp),
                                enabled = card.isCorrect == null,
                                onAnswer = {
                                    viewModel.checkAnswer(it)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}