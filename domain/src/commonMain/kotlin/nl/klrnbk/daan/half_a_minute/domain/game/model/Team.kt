package nl.klrnbk.daan.half_a_minute.domain.game.model

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

enum class TeamName {
    Blurple,
    Green,
    Yellow,
    Orange
}

@OptIn(ExperimentalUuidApi::class)
data class Team(
    val id: Uuid,
    val name: TeamName,
    val players: List<Player>,
    val pointsPerRound: List<Int>
)
