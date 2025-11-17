package nl.klrnbk.daan.half_a_minute.data.components.example.di

import nl.klrnbk.daan.half_a_minute.data.components.example.api.ExampleApi
import nl.klrnbk.daan.half_a_minute.data.config.ApiConfig
import nl.klrnbk.daan.half_a_minute.data.di.qualifiers.ExampleApiConfig
import nl.klrnbk.daan.half_a_minute.data.net.factory.HttpClientFactory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class ExampleModule {

    @Single
    fun provideApi(
        httpClientFactory: HttpClientFactory,
        @ExampleApiConfig apiConfig: ApiConfig,
    ): ExampleApi =
        ExampleApi(
            httpClientFactory.build(apiConfig.baseUrl),
        )
}
