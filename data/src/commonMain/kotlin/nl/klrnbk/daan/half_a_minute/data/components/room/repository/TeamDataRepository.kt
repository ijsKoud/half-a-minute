package nl.klrnbk.daan.half_a_minute.data.components.room.repository

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.data.components.room.AppDatabase
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.TeamEntity
import nl.klrnbk.daan.half_a_minute.data.components.room.mapper.TeamMapper
import nl.klrnbk.daan.half_a_minute.domain.game.model.Team
import nl.klrnbk.daan.half_a_minute.domain.game.model.TeamName
import nl.klrnbk.daan.half_a_minute.domain.game.repository.TeamRepository
import org.koin.core.annotation.Single

@Single
class TeamDataRepository(private val teamMapper: TeamMapper, private val database: AppDatabase) :
    TeamRepository {
    override suspend fun getTeamById(id: Uuid): Team? {
        val entity = database.teamDao().getById(id) ?: return null
        return teamMapper.map(entity)
    }

    override suspend fun createTeam(gameId: Uuid, name: TeamName): Team {
        val entity =
            TeamEntity(
                gameId = gameId,
                id = Uuid.random(),
                name = name,
                pointsPerRound = emptyList()
            )

        database.teamDao().insert(entity)
        return teamMapper.fromTeamEntity(entity)
    }

    override suspend fun removeTeam(id: Uuid) = database.teamDao().deleteById(id)
}
