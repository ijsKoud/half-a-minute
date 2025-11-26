package nl.klrnbk.daan.half_a_minute.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.data.room.dao.relations.GameWithTeamsPlayersAndHost
import nl.klrnbk.daan.half_a_minute.data.room.entity.GameEntity

@OptIn(ExperimentalUuidApi::class)
@Dao
interface GameDao {
    @Query("SELECT * FROM game WHERE game.id = :id")
    fun getById(id: Uuid): GameWithTeamsPlayersAndHost

    @Insert
    fun insert(game: GameEntity)
}
