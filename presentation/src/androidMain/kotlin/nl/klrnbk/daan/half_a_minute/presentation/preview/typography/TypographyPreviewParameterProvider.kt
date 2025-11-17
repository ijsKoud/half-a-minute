package nl.klrnbk.daan.half_a_minute.presentation.preview.typography

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nl.klrnbk.daan.half_a_minute.presentation.preview.typography.setup.model.TypographyPreviewModel
import nl.klrnbk.daan.half_a_minute.presentation.preview.typography.setup.provider.TypographyPreviewModelStubProvider

internal class TypographyPreviewParameterProvider :
    PreviewParameterProvider<TypographyPreviewModel> {
    override val values: Sequence<TypographyPreviewModel>
        get() = TypographyPreviewModelStubProvider.provideAll()
}
