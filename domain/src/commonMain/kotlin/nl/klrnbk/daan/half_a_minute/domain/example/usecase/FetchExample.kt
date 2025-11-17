package nl.klrnbk.daan.half_a_minute.domain.example.usecase

import nl.klrnbk.daan.half_a_minute.domain.example.model.Example
import nl.klrnbk.daan.half_a_minute.domain.example.repository.ExampleRepository
import org.koin.core.annotation.Factory

@Factory
class FetchExample(
    private val repository: ExampleRepository,
) {

    suspend operator fun invoke(): Result<Example> {
        return repository.fetchExample()
    }
}
