package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.example.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.klrnbk.daan.half_a_minute.domain.Platform
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.theme.dimension.Dimension
import kmp_template.presentation.generated.resources.Res
import kmp_template.presentation.generated.resources.ic_android_logo
import kmp_template.presentation.generated.resources.ic_apple_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun PlatformMessage(
    state: PlatformMessage,
) {
    val backgroundColor = when (state.platform) {
        Platform.ANDROID -> AppTheme.colors.components.platformMessage.androidBackground
        Platform.IOS -> AppTheme.colors.components.platformMessage.iosBackground
    }
    val image = when (state.platform) {
        Platform.ANDROID -> Res.drawable.ic_android_logo
        Platform.IOS -> Res.drawable.ic_apple_logo
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(Dimension.Padding.medium),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            contentDescription = "platform icon",
            painter = painterResource(image),
        )
        Spacer(modifier = Modifier.width(Dimension.Padding.medium))
        Text(
            color = AppTheme.colors.text,
            style = AppTheme.typography.bodyMedium,
            text = state.message,
        )
    }
}
