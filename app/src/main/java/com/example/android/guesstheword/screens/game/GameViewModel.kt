
package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel  :ViewModel(){
   private val _word = MutableLiveData<String>()
    val word :LiveData<String>
    get() = _word

  private  val _score = MutableLiveData<Int>()
    val score : MutableLiveData<Int>
get() = _score
     lateinit var wordList: MutableList<String>

private val _gameFinished = MutableLiveData<Boolean>()
    val gameFinished: LiveData<Boolean>
    get() = _gameFinished


    init {

        _gameFinished.value = false
       _score.value = 0
        Log.i("GameViewModel","gameViewModel is called")
        resetList()
        nextWord()

    }
     fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }
    fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            _gameFinished.value = true
        } else {
            _word.value = wordList.removeAt(0)
        }

    }


    fun onSkip() {
        score.value = score.value?.minus(1)
        nextWord()
    }

     fun onCorrect() {
        score.value = score.value?.plus(1)
        nextWord()
    }


    override fun onCleared() {
        super.onCleared()
    }

    fun gameFinsishedcomplete(){
        _gameFinished.value = false
    }
}