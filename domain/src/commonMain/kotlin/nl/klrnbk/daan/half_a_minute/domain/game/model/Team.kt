package nl.klrnbk.daan.half_a_minute.domain.game.model

enum class TeamName {
    Blurple,
    Green,
    Yellow,
    Orange
}

data class Team(
    val id: Long,
    val name: TeamName,
    val players: List<Player>,
    val pointsPerRound: List<Int>
)
