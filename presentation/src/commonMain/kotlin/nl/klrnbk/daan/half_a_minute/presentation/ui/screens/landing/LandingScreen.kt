package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton

@Composable
fun LandingScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.xxlarge)
    ) {
        Text(
            color = AppTheme.colors.text.base,
            style = AppTheme.typography.h1,
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
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
                onClick = {}
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