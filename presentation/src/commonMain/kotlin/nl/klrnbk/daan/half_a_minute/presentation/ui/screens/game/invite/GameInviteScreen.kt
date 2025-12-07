package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.button.StyledButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.components.GoBackButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite.components.InputForm
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite.components.PlayerListEntry
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite.components.PlayerListForm
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameInviteScreen(
    gameId: Uuid,
    navigateBack: () -> Unit,
    viewModel: GameInviteViewModel = koinViewModel()
) {
    LaunchedEffect(navigateBack) {
        viewModel.navigateBack = navigateBack
    }

    LaunchedEffect(gameId) {
        viewModel.loadGameDetails(gameId)
    }

    val gameState by viewModel.gameState.collectAsState()
    if (gameState == null) return

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.xlarge),
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {
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
                        append("Tell me about your ")
                        withStyle(
                            style = SpanStyle(color = AppTheme.colors.tertiary)
                        ) { append("friends") }
                        append("!")
                    }
            )
        }

        InputForm(
            onSubmit = viewModel::addPlayer,
            disabled = (gameState!!.players.size) >= 8
        )

        PlayerListForm(
            players = gameState!!.players,
            isDisabled = { it == gameState!!.host?.id },
            onDelete = viewModel::removePlayer,
            onSubmit = {}
        )
    }
}
