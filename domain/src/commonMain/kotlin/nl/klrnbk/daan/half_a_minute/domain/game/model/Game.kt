package nl.klrnbk.daan.half_a_minute.domain.game.model

import kotlin.uuid.Uuid

enum class GameStatus {
    ACTIVE,
    COMPLETED
}

data class Game(
    val id: Uuid,
    val pointsGoal: Int,
    val wordsPerRound: Int,
    val status: GameStatus,
    val host: Player?,
    val teams: List<Team>,
    val players: List<Player>
)
