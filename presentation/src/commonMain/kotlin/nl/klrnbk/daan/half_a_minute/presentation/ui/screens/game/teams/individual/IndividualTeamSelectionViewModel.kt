package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.individual

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
class IndividualTeamSelectionViewModel(
    private val getGameDetails: GetGameDetails,
    private val createTeam: CreateTeam,
    private val addPlayerToTeam: AddPlayerToTeam
) : ViewModel() {
    var navigateBack: () -> Unit = {}

    var navigateForward: () -> Unit = {}

    private val _gameState = MutableStateFlow<Game?>(null)
    val gameState = _gameState.asStateFlow()

    fun loadGameDetails(gameId: Uuid) {
        viewModelScope.launch {
            val game = getGameDetails(gameId) ?: return@launch navigateBack()
            _gameState.tryEmit(game)
        }
    }

    fun getMaxAmountOfTeams(): Int {
        val totalAmountOfPlayers = _gameState.value?.players?.size ?: return 1
        return floor(((totalAmountOfPlayers / 2).toDouble())).toInt()
    }

    fun setTeamAndContinue(playerId: Uuid, teamName: TeamName) {
        if (gameState.value == null) return
        viewModelScope.launch {
            setTeamForPlayer(playerId, teamName)
            navigateForward()
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
