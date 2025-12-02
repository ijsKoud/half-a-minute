package nl.klrnbk.daan.half_a_minute.domain.game.repository

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Team
import nl.klrnbk.daan.half_a_minute.domain.game.model.TeamName

interface TeamRepository {
    suspend fun getTeamById(id: Uuid): Team?
    suspend fun createTeam(gameId: Uuid, name: TeamName): Team
    suspend fun removeTeam(id: Uuid)
}
