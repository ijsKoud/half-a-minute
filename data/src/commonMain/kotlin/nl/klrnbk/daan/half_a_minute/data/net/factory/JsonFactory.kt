package nl.klrnbk.daan.half_a_minute.data.net.factory

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Single

@Single
class JsonFactory {

    @OptIn(ExperimentalSerializationApi::class)
    fun create(): Json {
        return Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            isLenient = true
            explicitNulls = false
        }
    }
}
