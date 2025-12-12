package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.utils.OnLifecycleEvent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoadingScreen(viewModel: LoadingScreenViewModel = koinViewModel()) {
    val messageState by viewModel.messageState.collectAsState()
    OnLifecycleEvent(
        onCreate = viewModel::startMessageFlow,
        onDestroy = viewModel::stopMessageFlow
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacing.xxlarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = AppTheme.colors.text.base,
            trackColor = AppTheme.colors.secondary
        )

        Text(
            text = messageState,
            color = AppTheme.colors.text.base,
            style = AppTheme.typography.body
        )
    }
}
