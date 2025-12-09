package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.math.floor
import kotlin.uuid.Uuid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.domain.game.model.Team
import nl.klrnbk.daan.half_a_minute.domain.game.model.TeamName
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.AddPlayerToTeam
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.ClearTeamSelection
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.CreateTeam
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.GetGameDetails
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class TeamSelectionControllerViewModel(
    private val getGameDetails: GetGameDetails,
    private val createTeam: CreateTeam,
    private val addPlayerToTeam: AddPlayerToTeam,
    private val clearTeamSelection: ClearTeamSelection
) : ViewModel() {
    var navigateBack: () -> Unit = {}

    var navigateForward: () -> Unit = {}

    private val _gameState = MutableStateFlow<Game?>(null)
    val gameState = _gameState.asStateFlow()

    private val _activePlayerState = MutableStateFlow<Player?>(null)
    val activePlayerState = _activePlayerState.asStateFlow()

    fun loadGameDetails(gameId: Uuid) {
        viewModelScope.launch {
            val game = getGameDetails(gameId) ?: return@launch navigateBack()
            _gameState.tryEmit(game)

            if (_activePlayerState.value == null) {
                _activePlayerState.tryEmit(game.players[0])
            }
        }
    }

    fun clearSelection(gameId: Uuid) {
        viewModelScope.launch { clearTeamSelection(gameId) }
    }

    fun isTeamDisabled(teamName: TeamName): Boolean {
        val state = _gameState.value ?: return true
        val availableTeams = state.teams.filter { it.players.isNotEmpty() }.map { it.name }

        val playerCount = state.players.size
        val currentIdx = state.players.indexOf(_activePlayerState.value)

        return playerCount == (currentIdx + 1) && !availableTeams.contains(teamName)
    }

    fun getMaxAmountOfTeams(): Int {
        val totalAmountOfPlayers = _gameState.value?.players?.size ?: return 1
        return floor(((totalAmountOfPlayers / 2).toDouble())).toInt()
    }

    fun setTeamAndContinue(playerId: Uuid, teamName: TeamName) {
        if (gameState.value == null) return
        viewModelScope.launch {
            setTeamForPlayer(playerId, teamName)

            val currentIdx = gameState.value!!.players.indexOfFirst { it.id == playerId }
            val nextPlayer = gameState.value!!.players.getOrNull(currentIdx + 1)
                ?: return@launch navigateForward()

            _activePlayerState.update { nextPlayer }
        }
    }

    private suspend fun setTeamForPlayer(playerId: Uuid, teamName: TeamName) {
        val team = getOrCreateTeam(teamName) ?: return

        addPlayerToTeam(playerId, team.id)
        if (gameState.value != null) loadGameDetails(gameState.value!!.id)
    }

    private suspend fun getOrCreateTeam(teamName: TeamName): Team? {
        if (gameState.value == null) return null

        val existingTeam = gameState.value?.teams?.find { it.name == teamName }
        if (existingTeam != null) return existingTeam

        return createTeam(gameState.value!!.id, teamName)
    }
}
