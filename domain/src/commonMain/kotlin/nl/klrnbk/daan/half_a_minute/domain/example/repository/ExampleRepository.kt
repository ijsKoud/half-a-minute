package nl.klrnbk.daan.half_a_minute.domain.example.repository

import nl.klrnbk.daan.half_a_minute.domain.example.model.Example
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage

interface ExampleRepository {

    suspend fun fetchExample(): Result<Example>

    fun getPlatformMessage(): PlatformMessage
}
