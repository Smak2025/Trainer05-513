package edu.gr05513.trainer05_513

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import edu.gr05513.trainer05_513.model.CardData

class MainViewModel : ViewModel(){
    val data by mutableStateOf(CardData())
    var isAnswered by mutableStateOf(false)

    fun checkAnswer(userValue: Int?){
        data.userResult = userValue
        isAnswered = true
    }
}