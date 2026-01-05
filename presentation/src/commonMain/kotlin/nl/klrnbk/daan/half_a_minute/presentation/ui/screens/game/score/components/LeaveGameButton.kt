package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.score.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.icons.ArrowLeft

@Composable
fun LeaveGameButton(modifier: Modifier = Modifier.fillMaxWidth(), onClick: () -> Unit) {
    StyledButton(
        modifier = modifier,
        onClick = onClick,
        style = AppTheme.colors.button.secondary,
        textOnly = true
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimension.Spacing.base),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = ArrowLeft, contentDescription = "Arrow pointing left")
            Text("Leave")
        }
    }
}
