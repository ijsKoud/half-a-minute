package nl.klrnbk.daan.half_a_minute.data.components.example.mapper

import nl.klrnbk.daan.half_a_minute.data.components.example.entity.ExampleEntity
import nl.klrnbk.daan.half_a_minute.domain.example.model.Example
import nl.klrnbk.daan.half_a_minute.domain.extension.requireNotNull
import org.koin.core.annotation.Factory

@Factory
class ExampleMapper {

    fun map(entity: ExampleEntity): Result<Example> = runCatching {
        Example(
            foo = entity.foo.requireNotNull(),
        )
    }
}
