package nl.klrnbk.daan.half_a_minute.data.net.factory

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpCallValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.plugins.resources.Resources
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.annotation.Single

@Single
class HttpClientFactory(
    private val jsonFactory: JsonFactory,
) {

    fun build(url: String): HttpClient {
        return HttpClient {
            install(HttpCallValidator)
            install(ContentNegotiation) {
                json(jsonFactory.create())
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(Resources)
            defaultRequest {
                url(url)
            }
        }
    }
}
