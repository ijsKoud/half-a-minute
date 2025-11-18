package nl.klrnbk.daan.half_a_minute.presentation.theme.typography.definition

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
data class AppTypography(
    val h1: TextStyle = TextStyle.Default,
    val body: TextStyle = TextStyle.Default,
    val button: TextStyle = TextStyle.Default,
    val input: TextStyle = TextStyle.Default,
)
