package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.presentation.state.ErrorDisplayState
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton

@Composable
fun ErrorScreen(state: ErrorDisplayState) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This shouldn't happen",
            style = AppTheme.typography.h1,
            color = AppTheme.colors.text.base
        )

        Text(
            text = "An error occurred: ${state.message}",
            style = AppTheme.typography.body,
            color = AppTheme.colors.text.base
        )

        StyledButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = state.action
        ) {
            Text("Continue")
        }
    }
}
