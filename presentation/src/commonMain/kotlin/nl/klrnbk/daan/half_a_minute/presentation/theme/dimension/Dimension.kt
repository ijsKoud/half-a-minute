package nl.klrnbk.daan.half_a_minute.presentation.theme.dimension

import androidx.compose.ui.unit.dp

object Dimension {

    object Padding {
        val xxsmall = 2.dp
        val xsmall = 4.dp
        val small = 8.dp
        val medium = 12.dp
        val large = 16.dp
        val xlarge = 24.dp
        val xxlarge = 32.dp
        val xxxlarge = 64.dp
    }

    object Spacing {
        val small = 4.dp
        val base = 8.dp
        val medium = 12.dp
        val large = 16.dp
        val xlarge = 32.dp
        val xxlarge = 64.dp
    }

    object BorderRadius {
        val medium = 12.dp
    }

    object Button {
        val borderRadius = BorderRadius.medium
        val horizontalPadding = Padding.large
        val verticalPadding = Padding.medium
    }

    object Input {
        val borderRadius = BorderRadius.medium
        val horizontalPadding = Padding.large
        val verticalPadding = Padding.medium
    }
}
