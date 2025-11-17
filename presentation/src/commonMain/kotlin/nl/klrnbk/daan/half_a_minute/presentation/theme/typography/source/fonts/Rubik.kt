package nl.klrnbk.daan.half_a_minute.presentation.theme.typography.source.fonts

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import kmp_template.presentation.generated.resources.Res
import kmp_template.presentation.generated.resources.rubik_black
import kmp_template.presentation.generated.resources.rubik_black_italic
import kmp_template.presentation.generated.resources.rubik_bold
import kmp_template.presentation.generated.resources.rubik_bold_italic
import kmp_template.presentation.generated.resources.rubik_light
import kmp_template.presentation.generated.resources.rubik_light_italic
import kmp_template.presentation.generated.resources.rubik_medium
import kmp_template.presentation.generated.resources.rubik_medium_italic
import org.jetbrains.compose.resources.Font

@Composable
fun rubikFontFamily() = FontFamily(
    Font(Res.font.rubik_light, weight = FontWeight.Light),
    Font(Res.font.rubik_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.rubik_medium, weight = FontWeight.Medium),
    Font(Res.font.rubik_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.rubik_bold, weight = FontWeight.Bold),
    Font(Res.font.rubik_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.rubik_black, weight = FontWeight.Black),
    Font(Res.font.rubik_black_italic, weight = FontWeight.Black, style = FontStyle.Italic),
)
