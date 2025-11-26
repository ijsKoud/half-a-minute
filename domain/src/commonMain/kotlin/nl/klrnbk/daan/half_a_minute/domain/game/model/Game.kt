package nl.klrnbk.daan.half_a_minute.domain.game.model

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

enum class GameStatus {
    ACTIVE,
    COMPLETED
}

@OptIn(ExperimentalUuidApi::class)
data class Game(
    val id: Uuid,
    val status: GameStatus,
    val host: Player,
    val teams: List<Team>,
    val players: List<Player>
)
