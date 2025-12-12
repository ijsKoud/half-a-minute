package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.loading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class LoadingScreenViewModel : ViewModel() {
    private val messageMutableState = MutableStateFlow("")
    val messageState = messageMutableState.asStateFlow()

    private var isLoading = false

    fun stopMessageFlow() {
        isLoading = false
    }

    fun startMessageFlow() {
        isLoading = true

        val messageOptions = listOf(
            "Almost done!",
            "We are still processing your request",
            "This takes a bit longer than usual",
            "Just a few more moments"
        )

        viewModelScope.launch {
            delay(2000L)
            while (isLoading) setMessageAndStartDelay(messageOptions)
        }
    }

    private suspend fun setMessageAndStartDelay(messages: List<String>) {
        messageMutableState.tryEmit(messages.random())
        delay(5000L)
    }
}
