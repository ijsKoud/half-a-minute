package nl.klrnbk.daan.half_a_minute.data.components.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import kotlin.uuid.ExperimentalUuidApi
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.PlayerEntity

@OptIn(ExperimentalUuidApi::class)
@Dao
interface PlayerDao {
    @Insert
    fun insert(entity: PlayerEntity)

    @Delete
    fun delete(entity: PlayerEntity)
}
