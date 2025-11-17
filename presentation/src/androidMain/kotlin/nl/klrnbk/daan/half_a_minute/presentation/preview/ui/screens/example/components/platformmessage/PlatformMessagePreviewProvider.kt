package nl.klrnbk.daan.half_a_minute.presentation.preview.ui.screens.example.components.platformmessage

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage

internal class PlatformMessagePreviewProvider() : PreviewParameterProvider<PlatformMessage> {
    override val values: Sequence<PlatformMessage>
        get() = sequenceOf(
            PlatformMessageStubProvider.provideAndroid(),
            PlatformMessageStubProvider.provideIos(),
        )
}
