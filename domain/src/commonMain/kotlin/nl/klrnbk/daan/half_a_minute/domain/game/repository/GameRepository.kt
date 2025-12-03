package nl.klrnbk.daan.half_a_minute.domain.game.repository

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game

interface GameRepository {
    suspend fun getGameById(id: Uuid): Game?
    suspend fun createGame(): Game
    suspend fun assignHostToGame(gameId: Uuid, hostId: Uuid): Game?
}
