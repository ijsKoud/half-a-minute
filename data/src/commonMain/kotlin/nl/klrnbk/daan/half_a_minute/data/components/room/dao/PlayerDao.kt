package nl.klrnbk.daan.half_a_minute.data.components.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.PlayerEntity

@Dao
interface PlayerDao {
    @Transaction
    @Query("SELECT * FROM player WHERE player.id = :id")
    suspend fun getById(id: Uuid): PlayerEntity?

    @Insert
    suspend fun insert(entity: PlayerEntity)

    @Transaction
    @Query("UPDATE player SET teamId = :teamId WHERE player.id = :playerId")
    suspend fun addPlayerToTeam(playerId: Uuid, teamId: Uuid)

    @Transaction
    @Query("DELETE FROM player WHERE player.id = :id")
    suspend fun deleteById(id: Uuid)
}
