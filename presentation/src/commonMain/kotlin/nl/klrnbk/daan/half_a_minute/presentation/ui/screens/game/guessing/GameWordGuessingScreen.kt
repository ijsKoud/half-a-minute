package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing.components.GuessableWordButton
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameWordGuessingScreen(
    words: List<String>,
    onEndOfRound: (guessedWords: List<String>) -> Unit,
    viewModel: GameWordGuessingViewModel = koinViewModel()
) {
    val guessedWordStates by viewModel.guessedWordsStates.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.xlarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.small),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items = words, key = { it }) {
                GuessableWordButton(
                    word = it,
                    guessed = guessedWordStates.contains(it),
                    toggleGuessedWord = { viewModel.toggleGuessedWord(it) }
                )
            }
        }
    }
}
