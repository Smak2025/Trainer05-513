package edu.gr05513.trainer05_513.model

import kotlin.random.Random

class CardData {
    val operation = Operation.entries.random()

    val value1: Int
    val value2: Int
    val result: Int

    init{
        when (operation){
            Operation.PLUS -> {
                value1 = Random.nextInt(-50, 51)
                value2 = Random.nextInt(-50, 51)
                result = value1 + value2
            }
            Operation.MINUS -> {
                value1 = Random.nextInt(-50, 51)
                value2 = Random.nextInt(-50, 51)
                result = value1 - value2
            }
            Operation.TIMES -> {
                value1 = Random.nextInt(-10, 11)
                value2 = Random.nextInt(-10, 11)
                result = value1 * value2
            }
            Operation.DIV -> {
                value2 = Random.nextInt(-10, 11)
                result = Random.nextInt(-10, 11)
                value1 = result * value2
            }
        }
    }

    var userResult: Int? = null

    val isCorrect: Boolean?
        get() = userResult?.let { it == result }
}
