package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class GameWordGuessingViewModel : ViewModel() {
    private val guessedWordsMutableStates = MutableStateFlow<List<String>>(listOf())
    val guessedWordsStates = guessedWordsMutableStates.asStateFlow()

    fun toggleGuessedWord(guessedWord: String) = guessedWordsMutableStates.update { words ->
        if (words.contains(guessedWord)) {
            val updatedGuessedWords = words.filterNot { word -> word == guessedWord }
            return@update updatedGuessedWords
        }

        (words.toMutableList() + guessedWord).toList()
    }
}
