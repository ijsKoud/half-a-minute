package nl.klrnbk.daan.half_a_minute.presentation.state

sealed interface DisplayState<out T>
class OnResult<out T>(val result: T) : DisplayState<T>
class OnError(val errorState: ErrorDisplayState) : DisplayState<Nothing>
data object OnLoading : DisplayState<Nothing>
