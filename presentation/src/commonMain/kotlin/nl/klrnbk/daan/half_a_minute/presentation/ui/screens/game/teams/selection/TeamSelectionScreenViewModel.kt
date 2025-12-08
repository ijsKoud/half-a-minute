package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.teams.selection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.uuid.Uuid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.GetPlayerDetails
import nl.klrnbk.daan.half_a_minute.presentation.state.DisplayState
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorDisplayState
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorState
import nl.klrnbk.daan.half_a_minute.presentation.state.LoadingState
import nl.klrnbk.daan.half_a_minute.presentation.state.ResultState
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class TeamSelectionScreenViewModel(private val getPlayerDetails: GetPlayerDetails) : ViewModel() {
    var navigateHome: () -> Unit = {}

    private val _playerMutableState = MutableStateFlow<DisplayState<Player>>(LoadingState())
    val playerState = _playerMutableState.asStateFlow()

    fun loadPlayerDetails(id: Uuid) {
        viewModelScope.launch {
            getPlayerDetails(id).fold(
                onSuccess = { _playerMutableState.tryEmit(ResultState(it)) },
                onFailure = {
                    val error = ErrorDisplayState(
                        message = it.message ?: "Unknown error occurred",
                        action = navigateHome
                    )

                    _playerMutableState.tryEmit(ErrorState(error))
                }
            )
        }
    }
}
