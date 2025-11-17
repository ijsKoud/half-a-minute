package nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val background: Color,
    val text: Color,
    val components: Components,
)

@Immutable
data class Components(
    val platformMessage: PlatformMessage,
)

@Immutable
data class PlatformMessage(
    val iosBackground: Color,
    val androidBackground: Color,
)