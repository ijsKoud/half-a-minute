package nl.klrnbk.daan.half_a_minute.presentation.ui.components.input

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

open class TextInputViewModel : ViewModel() {
    private val _state = MutableStateFlow(TextInputState(value = "", error = null))
    val state = _state
        .onStart { observeTextInput() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            TextInputState(value = "", error = null)
        )

    fun onInputChanged(input: String) {
        _state.update { it.copy(value = input) }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeTextInput() {
        state
            .mapLatest { it.value }
            .drop(1)
            .onEach { value ->
                val errorResponse = validateInputAndReturnError(value)
                _state.update { oldState -> oldState.copy(error = errorResponse) }
            }.launchIn(viewModelScope)
    }

    open fun validateInputAndReturnError(input: String): String? = null
}
