package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.components.GoBackButton
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.create.components.InputForm
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CreateGameScreen(
    navigateToLanding: () -> Unit,
    navigateToGameInvite: (Uuid) -> Unit,
    viewModel: CreateGameViewModel = koinViewModel()
) {
    LaunchedEffect(navigateToGameInvite) {
        viewModel.navigateToGamePage = navigateToGameInvite
    }

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
                    append("What should call ")
                    withStyle(
                        style = SpanStyle(color = AppTheme.colors.tertiary)
                    ) { append("you") }
                    append("?")
                }
        )

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.base)
        ) {
            InputForm(onSubmit = viewModel::onSubmit)
            GoBackButton(onClick = navigateToLanding)
        }
    }
}
