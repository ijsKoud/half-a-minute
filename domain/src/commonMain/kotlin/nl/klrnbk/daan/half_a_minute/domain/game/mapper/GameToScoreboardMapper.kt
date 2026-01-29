package nl.klrnbk.daan.half_a_minute.domain.game.mapper

import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.model.GameRound
import nl.klrnbk.daan.half_a_minute.domain.game.model.Scoreboard
import nl.klrnbk.daan.half_a_minute.domain.game.model.ScoreboardTeam
import nl.klrnbk.daan.half_a_minute.domain.game.model.Team
import org.koin.core.annotation.Factory

@Factory
class GameToScoreboardMapper {
    operator fun invoke(game: Game, next: GameRound, previousRoundScore: Int): Scoreboard {
        val teams = game.teams
            .sortedBy { it.pointsPerRound.reduceOrNull { a, b -> a + b } }
            .reversed()
            .mapIndexed { idx, team -> mapTeams(team, idx + 1) }
        val isGameFinished = teams.any { it.score >= game.pointsGoal }

        return Scoreboard(
            gameId = game.id,
            previousRoundScore = previousRoundScore,
            isGameFinished = isGameFinished,
            teams = teams,
            next = next
        )
    }

    private fun mapTeams(team: Team, position: Int) = ScoreboardTeam(
        name = team.name,
        position = position,
        score = team.pointsPerRound.reduceOrNull { a, b -> a + b } ?: 0
    )
}
