import androidx.compose.ui.window.ComposeUIViewController
import nl.klrnbk.daan.half_a_minute.data.context.ContextWrapper
import nl.klrnbk.daan.half_a_minute.presentation.ui.App

fun MainViewController() = ComposeUIViewController { App(ContextWrapper()) }
