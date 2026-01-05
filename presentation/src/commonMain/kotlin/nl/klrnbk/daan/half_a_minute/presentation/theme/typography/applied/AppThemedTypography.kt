package nl.klrnbk.daan.half_a_minute.presentation.theme.typography.applied

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import nl.klrnbk.daan.half_a_minute.presentation.theme.typography.definition.AppTypography
import nl.klrnbk.daan.half_a_minute.presentation.theme.typography.definition.DialogTypography
import nl.klrnbk.daan.half_a_minute.presentation.theme.typography.source.fonts.interFontFamily

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }

@Composable
fun appTypographies() = AppTypography(
    h1 = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 28.sp
    ),
    h2 = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    input = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    inputSupportMessage = TextStyle(
        fontFamily = interFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    dialog = DialogTypography(
        title = TextStyle(
            fontFamily = interFontFamily(),
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            lineHeight = 32.sp
        ),
        description = TextStyle(
            fontFamily = interFontFamily(),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp
        )
    )
)
