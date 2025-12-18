package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.overview.components.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.select.SelectMenu
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameSettingsForm(
    validationError: String,
    viewModel: GameSettingsFormViewModel = koinViewModel()
) {
    val pointsGoalState by viewModel.pointsGoalState.collectAsState()
    val wordsPerRoundState by viewModel.wordsPerRoundState.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.base)
    ) {
        Text(
            text = "Game settings",
            style = AppTheme.typography.body,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.text.base
        )

        SelectMenu(
            title = "Goal",
            options = gamePointsOptions,
            selected = pointsGoalState,
            onSelect = viewModel::updatePointsGoalOption
        )

        SelectMenu(
            title = "Words per round",
            options = wordsPerRoundOptions,
            selected = wordsPerRoundState,
            onSelect = viewModel::updateWordsPerRoundOption
        )
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.small)
    ) {
        if (validationError.isNotEmpty()) {
            Text(
                text = validationError,
                color = AppTheme.colors.danger
            )
        }

        StyledButton(
            modifier = Modifier.fillMaxWidth(),
            disabled = validationError.isNotEmpty(),
            style = AppTheme.colors.button.secondary,
            onClick = {}
        ) {
            Text("Let the game begin")
        }
    }
}
