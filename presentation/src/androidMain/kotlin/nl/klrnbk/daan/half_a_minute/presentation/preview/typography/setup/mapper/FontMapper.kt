package nl.klrnbk.daan.half_a_minute.presentation.preview.typography.setup.mapper

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import nl.klrnbk.daan.half_a_minute.presentation.preview.typography.setup.model.FontLabel
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme

class FontMapper {

    @Composable
    fun map(label: FontLabel): TextStyle {
        return when (label) {
            FontLabel.H1 -> AppTheme.typography.h1
        }
    }
}
