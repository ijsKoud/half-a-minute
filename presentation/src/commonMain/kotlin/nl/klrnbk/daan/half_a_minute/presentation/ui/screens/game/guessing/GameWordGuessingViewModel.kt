package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class GameWordGuessingViewModel : ViewModel() {
    private val guessedWordsMutableStates = MutableStateFlow<List<String>>(listOf())
    val guessedWordsStates = guessedWordsMutableStates.asStateFlow()

    private val countdownMutableState = MutableStateFlow(30)
    val countdownState = countdownMutableState.asStateFlow()

    fun startCountdown() = viewModelScope.launch {
        delay(1000L)
        while (countdownMutableState.value != 0) {
            countdownMutableState.update { it - 1 }
            delay(1000L)
        }
    }

    fun toggleGuessedWord(guessedWord: String) = guessedWordsMutableStates.update { words ->
        if (words.contains(guessedWord)) {
            val updatedGuessedWords = words.filterNot { word -> word == guessedWord }
            return@update updatedGuessedWords
        }

        (words.toMutableList() + guessedWord).toList()
    }
}
