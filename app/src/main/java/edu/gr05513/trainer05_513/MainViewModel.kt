package edu.gr05513.trainer05_513

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import edu.gr05513.trainer05_513.model.CardData

class MainViewModel : ViewModel(){
    val cards = mutableStateListOf<CardData>()
    var currentCard by mutableStateOf(0)
    var showResults by mutableStateOf(false)

    init {
        generateCards()
    }

    fun generateCards(){
        cards.clear()
        currentCard = 0
        repeat(MAX_CARDS){
            cards.add(CardData())
        }
    }

    fun checkAnswer(userValue: Int?){
        cards[currentCard].userResult = userValue
        currentCard++
        if (currentCard >= MAX_CARDS){
            currentCard=-1
            showResults = true
        }
    }

    companion object{
        const val MAX_CARDS = 5
    }
}