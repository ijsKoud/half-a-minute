package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Team
import nl.klrnbk.daan.half_a_minute.domain.game.model.TeamName
import nl.klrnbk.daan.half_a_minute.domain.game.repository.TeamRepository
import org.koin.core.annotation.Factory

@Factory
class CreateTeam(private val teamRepository: TeamRepository) {
    suspend operator fun invoke(gameId: Uuid, teamName: TeamName): Team =
        teamRepository.createTeam(gameId, teamName)
}
