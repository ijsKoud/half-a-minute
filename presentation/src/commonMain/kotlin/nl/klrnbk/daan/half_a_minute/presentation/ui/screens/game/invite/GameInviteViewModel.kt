package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.uuid.Uuid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.AddPlayerToGame
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.GetGameDetails
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.RemovePlayerById
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class GameInviteViewModel(
    private val getGameDetails: GetGameDetails,
    private val addPlayerToGame: AddPlayerToGame,
    private val removePlayerById: RemovePlayerById
) : ViewModel() {
    var navigateBack: () -> Unit = {}

    private val _gameState = MutableStateFlow<Game?>(null)
    val gameState = _gameState.asStateFlow()

    fun loadGameDetails(gameId: Uuid) {
        viewModelScope.launch {
            val game = getGameDetails(gameId)
            if (game == null) {
                navigateBack()
                return@launch
            }

            _gameState.tryEmit(game)
        }
    }

    fun addPlayer(name: String) {
        viewModelScope.launch {
            val game = gameState.value ?: return@launch
            val player = addPlayerToGame(name, game.id)
            _gameState.update { it?.copy(players = game.players + player) }
        }
    }

    fun removePlayer(id: Uuid) {
        viewModelScope.launch {
            val game = gameState.value ?: return@launch
            removePlayerById(id)

            _gameState.update {
                it?.copy(players = game.players.filterNot { player -> player.id === id })
            }
        }
    }
}
