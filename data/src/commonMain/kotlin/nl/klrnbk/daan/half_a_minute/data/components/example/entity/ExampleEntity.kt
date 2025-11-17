package nl.klrnbk.daan.half_a_minute.data.components.example.entity

import kotlinx.serialization.Serializable

/**
 * JSON
 * {
 *   foo: "bar"
 * }
 */
@Serializable
data class ExampleEntity(
    val foo: String?,
)
