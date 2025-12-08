package nl.klrnbk.daan.half_a_minute.presentation.state

data class ErrorDisplayState(val message: String, val action: () -> Unit)
