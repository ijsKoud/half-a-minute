package nl.klrnbk.daan.half_a_minute.presentation.theme.typography.source.fonts

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import half_a_minute.presentation.generated.resources.Res
import half_a_minute.presentation.generated.resources.inter_italic_vf
import half_a_minute.presentation.generated.resources.inter_vf
import org.jetbrains.compose.resources.Font

@Composable
fun interFontFamily() = FontFamily(
    Font(
        resource = Res.font.inter_vf,
        style = FontStyle.Normal,
        weight = FontWeight.Normal
    ),
    Font(
        resource = Res.font.inter_vf,
        style = FontStyle.Normal,
        weight = FontWeight.Bold
    ),
    Font(
        resource = Res.font.inter_italic_vf,
        style = FontStyle.Italic
    ),
)
