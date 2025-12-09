package nl.klrnbk.daan.half_a_minute.data.components.room.repository

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.PlayerDao
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.PlayerEntity
import nl.klrnbk.daan.half_a_minute.data.components.room.mapper.PlayerMapper
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.domain.game.repository.PlayerRepository
import org.koin.core.annotation.Single

@Single
class PlayerDataRepository(
    private val playerMapper: PlayerMapper,
    private val playerDao: PlayerDao
) : PlayerRepository {
    override suspend fun getPlayer(id: Uuid): Result<Player?> = runCatching {
        val entity = playerDao.getById(id)
        playerMapper.map(entity)
    }

    override suspend fun removePlayer(id: Uuid) = playerDao.deleteById(id)

    override suspend fun createPlayer(name: String, gameId: Uuid): Player {
        val entity = PlayerEntity(id = Uuid.random(), name = name, gameId = gameId, teamId = null)
        playerDao.insert(entity)

        return playerMapper.map(entity)!!
    }

    override suspend fun addPlayerToTeam(playerId: Uuid, teamId: Uuid): Player? {
        playerDao.addPlayerToTeam(playerId, teamId)
        return getPlayer(playerId).getOrNull()
    }

    override suspend fun clearPlayerTeamSelection(playerId: Uuid) =
        playerDao.addPlayerToTeam(playerId, null)
}
