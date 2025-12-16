package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.uuid.Uuid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.GetGameDetails
import nl.klrnbk.daan.half_a_minute.presentation.state.DisplayState
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorDisplayState
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorState
import nl.klrnbk.daan.half_a_minute.presentation.state.LoadingState
import nl.klrnbk.daan.half_a_minute.presentation.state.ResultState
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class GameOverviewViewModel(private val getGameDetails: GetGameDetails) : ViewModel() {
    var goHome: () -> Unit = {}

    private val _gameState = MutableStateFlow<DisplayState<Game>>(LoadingState())
    val gameState = _gameState.asStateFlow()

    private val _errorState = MutableStateFlow("")
    val errorState = _errorState.asStateFlow()

    fun loadGameDetails(gameId: Uuid) {
        viewModelScope.launch {
            val game = getGameDetails(gameId)
            if (game == null) {
                val state = ErrorDisplayState(message = "No game details found", action = goHome)
                _gameState.tryEmit(ErrorState(state))

                return@launch
            }

            _gameState.tryEmit(ResultState(game))
            runValidation(game)
        }
    }

    private fun runValidation(game: Game) {
        val containsInvalidTeamSizeError = game.teams.any { it.players.size <= 1 }
        if (containsInvalidTeamSizeError) {
            _errorState.tryEmit("Every team should have at least two players")
            return
        }
    }
}
