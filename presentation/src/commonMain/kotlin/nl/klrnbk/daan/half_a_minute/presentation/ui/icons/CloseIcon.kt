package nl.klrnbk.daan.half_a_minute.presentation.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val CloseIcon: ImageVector
    get() {
        if (_CloseIcon != null) return _CloseIcon!!

        _CloseIcon = ImageVector.Builder(
            name = "CloseIcon",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(7.116f, 8f)
                lineToRelative(-4.558f, 4.558f)
                lineToRelative(0.884f, 0.884f)
                lineTo(8f, 8.884f)
                lineToRelative(4.558f, 4.558f)
                lineToRelative(0.884f, -0.884f)
                lineTo(8.884f, 8f)
                lineToRelative(4.558f, -4.558f)
                lineToRelative(-0.884f, -0.884f)
                lineTo(8f, 7.116f)
                lineTo(3.442f, 2.558f)
                lineToRelative(-0.884f, 0.884f)
                lineTo(7.116f, 8f)
                close()
            }
        }.build()

        return _CloseIcon!!
    }

private var _CloseIcon: ImageVector? = null
