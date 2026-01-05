package nl.klrnbk.daan.half_a_minute.data.components.room.repository

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.data.components.room.AppDatabase
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.GameDao
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.GameEntity
import nl.klrnbk.daan.half_a_minute.data.components.room.mapper.GameMapper
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.model.GameStatus
import nl.klrnbk.daan.half_a_minute.domain.game.repository.GameRepository
import org.koin.core.annotation.Single

@Single
class GameDataRepository(private val gameMapper: GameMapper, private val gameDao: GameDao) :
    GameRepository {
    override suspend fun getGameById(id: Uuid): Game? {
        val gameEntity = gameDao.getById(id) ?: return null
        return gameMapper.map(gameEntity)
    }

    override suspend fun createGame(): Game {
        val gameId = Uuid.random()
        val gameEntity = GameEntity(
            id = gameId,
            status = GameStatus.ACTIVE,
            hostId = null,
            pointsGoal = 25,
            wordsPerRound = 5
        )

        gameDao.insert(gameEntity)
        return gameMapper.fromGameEntity(gameEntity)
    }

    override suspend fun assignHostToGame(gameId: Uuid, hostId: Uuid): Game? {
        gameDao.assignHostToGameById(gameId, hostId)
        return getGameById(gameId)
    }

    override suspend fun updateGameSettings(
        gameId: Uuid,
        pointsGoal: Int,
        wordsPerRound: Int
    ): Game? {
        gameDao.updatePointsGoal(gameId, pointsGoal)
        gameDao.updateWordsPerRound(gameId, wordsPerRound)

        return getGameById(gameId)
    }
}
