package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score.components

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

@Composable
fun GameScoreboardHeader(score: Int, leaveTheGame: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            LeaveGameButton(
                modifier = Modifier,
                onClick = leaveTheGame
            )
        }

        Text(
            modifier = Modifier.fillMaxWidth(),
            color = AppTheme.colors.text.base,
            style = AppTheme.typography.h1,
            textAlign = TextAlign.Left,
            text =
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = AppTheme.colors.tertiary)
                    ) { append("+$score") }
                    append(", what a great score!")
                }
        )
    }
}
