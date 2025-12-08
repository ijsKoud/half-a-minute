package nl.klrnbk.daan.half_a_minute.presentation.state

sealed interface DisplayState<out T>
class ResultState<out T>(val result: T) : DisplayState<T>
class ErrorState(val error: ErrorDisplayState) : DisplayState<Nothing>
class LoadingState : DisplayState<Nothing>
