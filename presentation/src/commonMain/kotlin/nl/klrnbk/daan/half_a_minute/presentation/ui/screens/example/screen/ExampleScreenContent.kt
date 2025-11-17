package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.components.PlatformMessage
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.components.Title

@Composable
fun ExampleScreenContent(
    state: PlatformMessage,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
            .padding(Dimension.Padding.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Title()
        Spacer(
            modifier = Modifier
                .height(Dimension.Padding.large),
        )
        PlatformMessage(
            state = state,
        )
    }
}
