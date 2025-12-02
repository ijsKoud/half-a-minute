package nl.klrnbk.daan.half_a_minute.domain.game.repository

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player

interface PlayerRepository {
    suspend fun getPlayer(id: Uuid): Player?
    suspend fun removePlayer(id: Uuid)
    suspend fun createPlayer(name: String): Player
    suspend fun addPlayerToTeam(playerId: Uuid, teamId: Uuid): Player?
}
