package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.DialogAction
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.DialogActionType
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.NativeDialog
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing.components.GameWordGuessingHeader
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing.components.GuessableWordsList
import nl.klrnbk.daan.half_a_minute.presentation.ui.utils.OnLifecycleEvent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameWordGuessingScreen(
    words: List<String>,
    onEndOfRound: (guessedWords: List<String>) -> Unit,
    viewModel: GameWordGuessingViewModel = koinViewModel()
) {
    OnLifecycleEvent(
        onCreate = { viewModel.startCountdown() }
    )

    val guessedWordState by viewModel.guessedWordsState.collectAsState()
    val countdownState by viewModel.countdownState.collectAsState()

    val showEndOfRoundDialogState by viewModel.showEndOfRoundDialogState.collectAsState()
    val wordSelectionTimeState by viewModel.wordSelectionTimeState.collectAsState()

    if (showEndOfRoundDialogState) {
        NativeDialog(
            title = "The half a minute is over!",
            description = "Select the correctly guessed words before moving on to the next round.",
            actions = listOf(
                DialogAction(
                    name = "Continue",
                    type = DialogActionType.SUBMIT,
                    action = viewModel::activateWordSelectionTime
                )
            )
        )
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.xlarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GameWordGuessingHeader(
            countdownState = countdownState,
            wordSelectionTime = wordSelectionTimeState
        )

        GuessableWordsList(
            words = words,
            guessedWords = guessedWordState,
            wordSelectionTime = wordSelectionTimeState,
            toggleGuessedWord = viewModel::toggleGuessedWord
        )

        if (wordSelectionTimeState) {
            StyledButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onEndOfRound(guessedWordState) },
                style = AppTheme.colors.button.secondary
            ) {
                Text("End this round")
            }
        }
    }
}
