package nl.klrnbk.daan.half_a_minute.data.components.room.mapper

import nl.klrnbk.daan.half_a_minute.data.components.room.dao.relations.GameWithTeamsPlayersAndHost
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.GameEntity
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import org.koin.core.annotation.Factory

@Factory
class GameMapper(private val teamMapper: TeamMapper, private val playerMapper: PlayerMapper) {
    fun map(entity: GameWithTeamsPlayersAndHost): Game {
        val mappedTeams = entity.teams.map(teamMapper::map)
        val mappedPlayers = entity.players.mapNotNull(playerMapper::map)

        return Game(
            id = entity.game.id,
            status = entity.game.status,
            host = playerMapper.map(entity.host),
            teams = mappedTeams,
            players = mappedPlayers
        )
    }

    fun fromGameEntity(entity: GameEntity): Game = Game(
        id = entity.id,
        status = entity.status,
        host = null,
        teams = emptyList(),
        players = emptyList()
    )
}
