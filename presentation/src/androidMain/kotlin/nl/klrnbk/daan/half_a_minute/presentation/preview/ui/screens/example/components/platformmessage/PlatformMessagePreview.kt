package nl.klrnbk.daan.half_a_minute.presentation.preview.ui.screens.example.components.platformmessage

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.components.PlatformMessage

const val previewLegend = "model 0 = Android message, model 1 = IOS message"

@Preview(name = previewLegend)
@Composable
private fun Preview(@PreviewParameter(PlatformMessagePreviewProvider::class) model: PlatformMessage) {
    AppTheme {
        PlatformMessage(
            state = model,
        )
    }
}
