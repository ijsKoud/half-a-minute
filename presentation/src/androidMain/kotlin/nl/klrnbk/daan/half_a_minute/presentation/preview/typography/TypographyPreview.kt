package nl.klrnbk.daan.half_a_minute.presentation.preview.typography

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import nl.klrnbk.daan.half_a_minute.presentation.preview.typography.setup.mapper.FontMapper
import nl.klrnbk.daan.half_a_minute.presentation.preview.typography.setup.model.TypographyPreviewModel
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension

@Preview
@Composable
private fun Preview(@PreviewParameter(TypographyPreviewParameterProvider::class) model: TypographyPreviewModel) {
    val fontMapper = FontMapper()
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = AppTheme.colors.background,
                    shape = RoundedCornerShape(Dimension.Padding.medium),
                )
                .padding(Dimension.Padding.medium),
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Color.Magenta,
                        shape = RoundedCornerShape(Dimension.Padding.medium),
                    )
                    .padding(Dimension.Padding.xsmall),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = model.label.name,
                    color = AppTheme.colors.text,
                    style = fontMapper.map(model.label),
                )
            }
            Text(
                text = model.text,
                color = AppTheme.colors.text,
                style = fontMapper.map(model.label),
            )
        }
    }
}
