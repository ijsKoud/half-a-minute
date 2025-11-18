package nl.klrnbk.daan.half_a_minute.presentation.theme.typography.source.fonts

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import half_a_minute.presentation.generated.resources.Res
import half_a_minute.presentation.generated.resources.inter_italic_vf
import half_a_minute.presentation.generated.resources.inter_vf
import org.jetbrains.compose.resources.Font

@Composable
fun interFontFamily() = FontFamily(
    Font(Res.font.inter_vf),
    Font(Res.font.inter_italic_vf),
)
