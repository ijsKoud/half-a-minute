package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.uuid.Uuid
import kotlinx.coroutines.launch
import nl.klrnbk.daan.half_a_minute.domain.extension.guard
import nl.klrnbk.daan.half_a_minute.domain.game.usecase.CreateGameWithHost
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class CreateGameViewModel(private val createGameWithHost: CreateGameWithHost) : ViewModel() {
    var navigateToGamePage: (Uuid) -> Unit = {
        println(it.toString())
    }

    fun onSubmit(hostName: String) {
        viewModelScope.launch {
            val result = createGameWithHost(hostName)
            result.fold(
                onSuccess = { navigateToGamePage(it) },
                onFailure = { println(it) }
            )
        }
    }
}
