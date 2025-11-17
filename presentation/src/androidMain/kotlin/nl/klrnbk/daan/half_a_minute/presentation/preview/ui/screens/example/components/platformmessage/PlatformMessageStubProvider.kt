package nl.klrnbk.daan.half_a_minute.presentation.preview.ui.screens.example.components.platformmessage

import nl.klrnbk.daan.half_a_minute.domain.Platform
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage

object PlatformMessageStubProvider {

    fun provideAndroid(): PlatformMessage = PlatformMessage(
        message = "message from Android",
        platform = Platform.ANDROID,
    )

    fun provideIos(): PlatformMessage = PlatformMessage(
        message = "message from iOS",
        platform = Platform.IOS,
    )
}
