package nl.klrnbk.daan.half_a_minute.domain.example.model

import nl.klrnbk.daan.half_a_minute.domain.Platform

data class PlatformMessage(
    val message: String,
    val platform: Platform,
)
