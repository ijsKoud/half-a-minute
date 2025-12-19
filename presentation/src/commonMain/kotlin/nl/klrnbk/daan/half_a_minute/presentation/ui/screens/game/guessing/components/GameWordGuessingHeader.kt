package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme

@Composable
fun GameWordGuessingHeader(countdownState: Int, wordSelectionTime: Boolean) {
    if (wordSelectionTime) {
        Text(
            text = buildAnnotatedString {
                append("Show me how ")
                withStyle(
                    style = SpanStyle(color = AppTheme.colors.tertiary)
                ) { append("you") }
                append(" played!")
            },
            style = AppTheme.typography.h1,
            color = AppTheme.colors.text.base
        )

        return
    }

    Text(
        text = countdownState.toString(),
        style = AppTheme.typography.h1,
        color = AppTheme.colors.text.base
    )
}
