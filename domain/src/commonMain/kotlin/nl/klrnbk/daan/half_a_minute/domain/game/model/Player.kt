package nl.klrnbk.daan.half_a_minute.domain.game.model

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
data class Player(val id: Uuid, val name: String)
