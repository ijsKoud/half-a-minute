package nl.klrnbk.daan.half_a_minute.data.components.example.api

import nl.klrnbk.daan.half_a_minute.data.components.example.entity.ExampleEntity
import nl.klrnbk.daan.half_a_minute.data.net.extension.get
import nl.klrnbk.daan.half_a_minute.data.net.model.Response
import io.ktor.client.HttpClient
import io.ktor.resources.Resource

@Suppress("unused")
class ExampleApi(
    private val httpClient: HttpClient,
) {

    // regular path call
    @Resource("/set_your_path_here")
    class Example()

    // query parms /animals?type=cat
    @Resource("/animals")
    class Animals(
        val type: String? = "cat",
    )

    // subroute path call /animals/extinct
    @Resource("/animals")
    class AnimalsSub() {
        @Resource("extinct")
        class Extinct(val parent: AnimalsSub = AnimalsSub())
    }

    // path params call /animals/dog
    @Resource("/animals")
    class AnimalsPathParam {
        @Resource("{type}")
        class Type(val parent: AnimalsPathParam = AnimalsPathParam(), val type: String)
    }

    suspend fun getExample(): Response<ExampleEntity> =
        httpClient.get(Example)
}
