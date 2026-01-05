package nl.klrnbk.daan.half_a_minute.domain.game.model

import kotlin.uuid.Uuid

data class Scoreboard(
    val gameId: Uuid,
    val previousGameScore: Int,
    val isGameFinished: Boolean,
    val teams: List<ScoreboardTeam>
)

data class ScoreboardTeam(val name: TeamName, val position: Int, val score: Int) {
    fun toScoreString(): String = "$score pt(s)"
    fun toPositionString(): String = when (position) {
        1 -> "1st"
        2 -> "2nd"
        3 -> "3rd"
        else -> "${position}th"
    }
}
