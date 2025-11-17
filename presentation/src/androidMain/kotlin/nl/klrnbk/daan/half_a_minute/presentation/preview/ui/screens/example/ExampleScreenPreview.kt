package nl.klrnbk.daan.half_a_minute.presentation.preview.ui.screens.example

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage
import nl.klrnbk.daan.half_a_minute.presentation.preview.ui.screens.example.components.platformmessage.PlatformMessagePreviewProvider
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.screen.ExampleScreenContent

@Preview
@Composable
private fun Preview(@PreviewParameter(PlatformMessagePreviewProvider::class) state: PlatformMessage) {
    AppTheme {
        ExampleScreenContent(
            state = state,
        )
    }
}
