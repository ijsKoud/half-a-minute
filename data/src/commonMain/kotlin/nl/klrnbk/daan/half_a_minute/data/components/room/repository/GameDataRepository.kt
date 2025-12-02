package nl.klrnbk.daan.half_a_minute.data.components.room.repository

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.data.components.room.AppDatabase
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.GameEntity
import nl.klrnbk.daan.half_a_minute.data.components.room.mapper.GameMapper
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.model.GameStatus
import nl.klrnbk.daan.half_a_minute.domain.game.repository.GameRepository

class GameDataRepository(private val gameMapper: GameMapper, private val database: AppDatabase) :
    GameRepository {
    override suspend fun getGameById(id: Uuid): Game? {
        val gameEntity = database.gameDao().getById(id) ?: return null
        return gameMapper.map(gameEntity)
    }

    override suspend fun createGame(hostUserName: String): Game {
        val gameId = Uuid.random()
        val gameEntity = GameEntity(
            id = gameId,
            status = GameStatus.ACTIVE,
            hostId = null
        )

        database.gameDao().insert(gameEntity)
        return gameMapper.fromGameEntity(gameEntity)
    }

    override suspend fun assignHostToGame(gameId: Uuid, hostId: Uuid): Game? {
        database.gameDao().assignHostToGameById(gameId, hostId)
        return getGameById(gameId)
    }
}
