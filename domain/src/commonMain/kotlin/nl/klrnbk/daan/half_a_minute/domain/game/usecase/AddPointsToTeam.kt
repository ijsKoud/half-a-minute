package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.domain.game.model.Team
import nl.klrnbk.daan.half_a_minute.domain.game.repository.PlayerRepository
import nl.klrnbk.daan.half_a_minute.domain.game.repository.TeamRepository
import org.koin.core.annotation.Factory

@Factory
class AddPointsToTeam(private val teamRepository: TeamRepository) {
    suspend operator fun invoke(teamId: Uuid, points: Int): Team? =
        teamRepository.addPointsToTeam(teamId, points)
}
