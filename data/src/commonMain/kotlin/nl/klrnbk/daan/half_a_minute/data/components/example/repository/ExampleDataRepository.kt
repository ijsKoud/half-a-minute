package nl.klrnbk.daan.half_a_minute.data.components.example.repository

import nl.klrnbk.daan.half_a_minute.data.components.example.api.ExampleApi
import nl.klrnbk.daan.half_a_minute.data.components.example.mapper.ExampleMapper
import nl.klrnbk.daan.half_a_minute.data.components.example.platform.PlatformMessenger
import nl.klrnbk.daan.half_a_minute.data.net.mapper.ResponseMapper
import nl.klrnbk.daan.half_a_minute.domain.example.model.Example
import nl.klrnbk.daan.half_a_minute.domain.example.model.PlatformMessage
import nl.klrnbk.daan.half_a_minute.domain.example.repository.ExampleRepository
import nl.klrnbk.daan.half_a_minute.domain.extension.guard
import org.koin.core.annotation.Single

@Single
class ExampleDataRepository(
    private val api: ExampleApi,
    private val responseMapper: ResponseMapper,
    private val exampleMapper: ExampleMapper,
    private val platformMessenger: PlatformMessenger,
) : ExampleRepository {

    override suspend fun fetchExample(): Result<Example> {
        val response = Result.runCatching {
            api.getExample()
        }.guard { return it }
        val result = responseMapper.mapResponse(response).guard { return it }
        return exampleMapper.map(result)
    }

    override fun getPlatformMessage(): PlatformMessage {
        return platformMessenger.getPlatformName()
    }
}
