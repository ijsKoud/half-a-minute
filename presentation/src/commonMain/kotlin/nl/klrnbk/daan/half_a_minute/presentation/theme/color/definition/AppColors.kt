package nl.klrnbk.daan.half_a_minute.presentation.theme.color.definition

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val name: String,
    val darkMode: Boolean,
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val black: Color,
    val white: Color,
    val danger: Color,

    val text: TextColors,
    val input: InputsGroup,
    val button: ButtonsGroup,
)

@Immutable
data class TextColors(
    val base: Color,
)

@Immutable
data class InputsGroup(
    val default: Interaction,
    val danger: Interaction
)

@Immutable
data class ButtonsGroup(
    val primary: Interaction,
    val secondary: Interaction,
    val danger: Interaction,
)

@Immutable
data class Interaction(
    val background: InteractionColors,
    val text: InteractionColors
)

@Immutable
data class InteractionColors(
    val base: Color,
    val muted: Color
)