package nl.klrnbk.daan.half_a_minute.data.components.room.mapper

import nl.klrnbk.daan.half_a_minute.data.components.room.dao.relations.TeamWithPlayersRelation
import nl.klrnbk.daan.half_a_minute.domain.game.model.Team
import org.koin.core.annotation.Factory

@Factory
class TeamMapper(private val playerMapper: PlayerMapper) {
    fun map(entity: TeamWithPlayersRelation): Team {
        val mappedPlayers = entity.players.mapNotNull(playerMapper::map)
        return Team(
            id = entity.team.id,
            name = entity.team.name,
            pointsPerRound = entity.team.pointsPerRound,
            players = mappedPlayers
        )
    }
}
