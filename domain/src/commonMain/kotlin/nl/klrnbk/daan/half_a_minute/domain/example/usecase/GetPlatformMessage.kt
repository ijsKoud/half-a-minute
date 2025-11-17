package nl.klrnbk.daan.half_a_minute.domain.example.usecase

import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage
import nl.klrnbk.daan.half_a_minute.domain.example.repository.ExampleRepository
import org.koin.core.annotation.Factory

@Factory
class GetPlatformMessage(
    private val exampleRepository: ExampleRepository,
) {

    operator fun invoke(): PlatformMessage {
        return exampleRepository.getPlatformMessage()
    }
}
