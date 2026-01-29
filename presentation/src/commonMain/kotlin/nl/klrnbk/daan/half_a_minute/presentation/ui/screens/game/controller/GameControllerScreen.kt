package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.controller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.GameRound
import nl.klrnbk.daan.half_a_minute.domain.game.model.Scoreboard
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorState
import nl.klrnbk.daan.half_a_minute.presentation.state.LoadingState
import nl.klrnbk.daan.half_a_minute.presentation.state.ResultState
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.DialogAction
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.DialogActionType
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.dialog.NativeDialog
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.error.ErrorScreen
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing.GameWordGuessingScreen
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score.GameScoreboardScreen
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.loading.LoadingScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameControllerScreen(
    gameId: Uuid,
    leaveTheGame: () -> Unit,
    viewModel: GameControllerViewModel = koinViewModel()
) {
    LaunchedEffect(gameId) {
        viewModel.goHome = leaveTheGame
        viewModel.loadGameDetails(gameId)
    }

    val displayState by viewModel.gameState.collectAsState()
    val scoreboardState by viewModel.scoreboardState.collectAsState()
    val roundState by viewModel.roundState.collectAsState()
    val roundOrderState by viewModel.roundOrderState.collectAsState()
    val randomWordsState by viewModel.randomWordsState.collectAsState()

    when (val state = displayState) {
        is ResultState -> GameControllerScreenContent(
            scoreboard = scoreboardState,
            next = roundOrderState[roundState],
            leaveTheGame = leaveTheGame,
            continueToNextRound = viewModel::continueToNextRound,
            randomWords = randomWordsState,
            onEndOfRound = { teamId, guessedAmount ->
                viewModel.onEndOfRound(state.result, teamId, guessedAmount)
            }
        )

        is LoadingState -> LoadingScreen()

        is ErrorState -> ErrorScreen(state.error)
    }
}

@Composable
fun GameControllerScreenContent(
    scoreboard: Scoreboard?,
    randomWords: List<String>,
    next: GameRound,
    onEndOfRound: (teamId: Uuid, guessedAmount: Int) -> Unit,
    continueToNextRound: () -> Unit,
    leaveTheGame: () -> Unit
) {
    when (scoreboard) {
        null -> {
            var isPlayerReady by remember { mutableStateOf(false) }
            if (!isPlayerReady) {
                NativeDialog(
                    title = "You are up ${next.player.name}!",
                    description = "Ready to start?",
                    actions = listOf(
                        DialogAction(
                            name = "Continue",
                            type = DialogActionType.DISMISS,
                            action = { isPlayerReady = isPlayerReady.not() }
                        )
                    )
                )
                return
            }

            GameWordGuessingScreen(
                words = randomWords,
                onEndOfRound = { onEndOfRound(next.team.id, it.size) }
            )
        }

        else -> GameScoreboardScreen(
            scoreboard = scoreboard,
            continueToNextRound = continueToNextRound,
            leaveTheGame = leaveTheGame
        )
    }
}
