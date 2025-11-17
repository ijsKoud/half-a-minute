package nl.klrnbk.daan.half_a_minute.presentation.theme.typography.applied

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import nl.klrnbk.daan.half_a_minute.presentation.theme.typography.definition.AppTypography
import nl.klrnbk.daan.half_a_minute.presentation.theme.typography.source.fonts.rubikFontFamily

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }

@Composable
fun AppTypographies() = AppTypography(
    h1 = TextStyle(
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    ),
    h2 = TextStyle(
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    h3 = TextStyle(
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    bodyThin = TextStyle(
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Thin,
        fontSize = 16.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
    ),
    button = TextStyle(
        fontFamily = rubikFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
)
