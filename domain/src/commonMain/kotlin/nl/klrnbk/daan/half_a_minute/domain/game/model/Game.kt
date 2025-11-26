package nl.klrnbk.daan.half_a_minute.domain.game.model

enum class GameStatus {
    ACTIVE,
    COMPLETED
}

data class Game(
    val id: Long,
    val status: GameStatus,
    val host: Player,
    val teams: List<Team>,
    val players: List<Player>
)
