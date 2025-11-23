package nl.klrnbk.daan.half_a_minute.presentation.ui.helpers

import androidx.compose.ui.graphics.Color
import platform.CoreGraphics.CGFloat
import platform.UIKit.UIColor

fun Color.toUIColor(): UIColor =
    UIColor(
        red = this.red.toCGFloat(),
        green = this.green.toCGFloat(),
        blue = this.blue.toCGFloat(),
        alpha = this.alpha.toCGFloat()
    )

private fun Float.toCGFloat(): CGFloat = this.toDouble()