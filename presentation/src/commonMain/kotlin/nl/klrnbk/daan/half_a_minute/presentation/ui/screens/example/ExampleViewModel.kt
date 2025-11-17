package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage
import nl.klrnbk.daan.half_a_minute.domain.example.usecase.GetPlatformMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ExampleViewModel(
    private val getPlatformMessage: GetPlatformMessage,
) : ViewModel() {

    private val mutablePlatformMessage: MutableStateFlow<PlatformMessage?> = MutableStateFlow(null)
    val platformMessage: StateFlow<PlatformMessage?> = mutablePlatformMessage.asStateFlow()

    init {
        fetchPlatformMessage()
    }

    private fun fetchPlatformMessage() {
        viewModelScope.launch {
            mutablePlatformMessage.emit(getPlatformMessage())
        }
    }
}
