package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.uuid.Uuid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import nl.klrnbk.daan.half_a_minute.domain.game.mapper.GameToScoreboardMapper
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.domain.game.model.Scoreboard
import nl.klrnbk.daan.half_a_minute.domain.game.model.Team
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.AddPointsToTeam
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.GetGameDetails
import nl.klrnbk.daan.half_a_minute.presentation.state.DisplayState
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorDisplayState
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorState
import nl.klrnbk.daan.half_a_minute.presentation.state.LoadingState
import nl.klrnbk.daan.half_a_minute.presentation.state.ResultState
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing.getRandomWords
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class GameControllerViewModel(
    private val getGameDetails: GetGameDetails,
    private val addPointsToTeam: AddPointsToTeam,
    private val gameToScoreboardMapper: GameToScoreboardMapper
) : ViewModel() {
    var goHome: () -> Unit = {}

    private val _gameState = MutableStateFlow<DisplayState<Game>>(LoadingState())
    val gameState = _gameState.asStateFlow()

    private val _roundsState = MutableStateFlow(0)
    val roundState = _roundsState.asStateFlow()

    private val _roundOrderState = MutableStateFlow<List<Pair<Team, Player>>>(listOf())
    val roundOrderState = _roundOrderState.asStateFlow()

    private val _scoreboardState = MutableStateFlow<Scoreboard?>(null)
    val scoreboardState = _scoreboardState.asStateFlow()

    private val _randomWordsState = MutableStateFlow(getRandomWords(5))
    val randomWordsState = _randomWordsState.asStateFlow()

    fun loadGameDetails(gameId: Uuid) {
        viewModelScope.launch {
            val game = getGameDetails(gameId)
            if (game == null) {
                val state = ErrorDisplayState(message = "No game details found", action = goHome)
                _gameState.tryEmit(ErrorState(state))

                return@launch
            }

            val roundOrder = getRoundOrder(game)
            _roundOrderState.tryEmit(roundOrder)

            _randomWordsState.update { getRandomWords(game.wordsPerRound) }
            _gameState.tryEmit(ResultState(game))
        }
    }

    fun continueToNextRound() = _scoreboardState.tryEmit(null)

    fun onEndOfRound(game: Game, teamId: Uuid, guessedAmount: Int) {
        viewModelScope.launch {
            _roundsState.update { it + 1 }
            _randomWordsState.update { getRandomWords(game.wordsPerRound) }

            val team = addPointsToTeam(teamId, guessedAmount)
            if (team == null) {
                val state = ErrorDisplayState(message = "No team details found", action = goHome)
                _gameState.tryEmit(ErrorState(state))

                return@launch
            }

            val newTeams = game.teams.filterNot { it.id == team.id }.toMutableList() + team
            val newGame = game.copy(teams = newTeams)
            _gameState.tryEmit(ResultState(newGame))

            val next = getNextUp(_roundsState.value)
            val scoreboard = gameToScoreboardMapper(game, next, guessedAmount)
            _scoreboardState.tryEmit(scoreboard)
        }
    }

    private fun getNextUp(roundIdx: Int): Pair<Team, Player> {
        if (_roundOrderState.value.size >= roundIdx) {
            _roundsState.update { it + 1 }
            return _roundOrderState.value.first()
        }

        return _roundOrderState.value[roundIdx]
    }

    private fun getRoundOrder(game: Game): List<Pair<Team, Player>> {
        val maxPlayers = game.teams.maxOfOrNull { it.players.size } ?: 0
        val order = mutableListOf<Pair<Team, Player>>()

        for (playerIndex in 0 until maxPlayers) {
            for (team in game.teams) {
                if (playerIndex < team.players.size) {
                    val player = team.players[playerIndex]
                    order += Pair(team, player)
                }
            }
        }

        return order.toList()
    }
}
