package nl.klrnbk.daan.half_a_minute.data.components.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.relations.GameWithTeamsPlayersAndHost
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.GameEntity

@Dao
interface GameDao {
    @Transaction
    @Query("SELECT * FROM game WHERE game.id = :id")
    suspend fun getById(id: Uuid): GameWithTeamsPlayersAndHost

    @Insert
    suspend fun insert(game: GameEntity)
}
