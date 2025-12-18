package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.components.GoBackButton

@Composable
fun GameOverviewHeader(navigateBack: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            GoBackButton(
                modifier = Modifier,
                onClick = navigateBack
            )
        }

        Text(
            color = AppTheme.colors.text.base,
            style = AppTheme.typography.h1,
            textAlign = TextAlign.Center,
            text =
                buildAnnotatedString {
                    append("Ready to win a game of ")
                    withStyle(
                        style = SpanStyle(color = AppTheme.colors.tertiary)
                    ) { append("half a minute") }
                    append("?")
                }
        )
    }
}
