package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.landing

import androidx.compose.foundation.layout.Arrangement
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
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton

@Composable
fun LandingScreen(navigateToCreateGame: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.xxlarge)
    ) {
        Text(
            color = AppTheme.colors.text.base,
            style = AppTheme.typography.h1,
            textAlign = TextAlign.Center,
            text =
            buildAnnotatedString {
                append("Ready to guess words in ")
                withStyle(
                    style = SpanStyle(color = AppTheme.colors.tertiary)
                ) { append("half a minute") }
                append("?")
            }
        )

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.base)
        ) {
            StyledButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = navigateToCreateGame
            ) {
                Text("New game")
            }

            StyledButton(
                modifier = Modifier.fillMaxWidth(),
                disabled = true, // Disable the option until functionality is added!
                onClick = {}
            ) {
                Text("Join a game")
            }
        }
    }
}
