package nl.klrnbk.daan.half_a_minute.presentation.preview.typography.setup.provider

import nl.klrnbk.daan.half_a_minute.presentation.preview.typography.setup.model.FontLabel
import nl.klrnbk.daan.half_a_minute.presentation.preview.typography.setup.model.TypographyPreviewModel

internal object TypographyPreviewModelStubProvider {

    private const val DEFAULT_TEXT = "The quick brown fox jumps over the lazy dog"

    fun provideAll(): Sequence<TypographyPreviewModel> = sequenceOf(
        provideH1(),
    )

    private fun provide(
        label: FontLabel = FontLabel.H1,
        text: String = DEFAULT_TEXT,
    ): TypographyPreviewModel = TypographyPreviewModel(
        label,
        text,
    )

    private fun provideH1() = provide(
        label = FontLabel.H1,
    )
}
