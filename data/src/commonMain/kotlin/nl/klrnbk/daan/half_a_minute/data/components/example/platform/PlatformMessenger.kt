package nl.klrnbk.daan.half_a_minute.data.components.example.platform

import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage
import org.koin.core.annotation.Factory

@Factory
expect class PlatformMessenger {

    fun getPlatformName(): PlatformMessage
}
