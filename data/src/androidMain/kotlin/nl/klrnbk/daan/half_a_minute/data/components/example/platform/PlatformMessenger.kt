package nl.klrnbk.daan.half_a_minute.data.components.example.platform

import nl.klrnbk.daan.half_a_minute.domain.Platform
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage
import org.koin.core.annotation.Factory

@Factory
actual class PlatformMessenger {

    actual fun getPlatformName(): PlatformMessage {
        return PlatformMessage(
            message = "Hello! This is from Android!",
            platform = Platform.ANDROID,
        )
    }
}
