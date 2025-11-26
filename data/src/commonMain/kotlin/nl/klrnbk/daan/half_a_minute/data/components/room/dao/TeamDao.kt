package nl.klrnbk.daan.half_a_minute.data.components.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.TeamEntity

@Dao
interface TeamDao {
    @Insert
    suspend fun insert(entity: TeamEntity)

    @Update
    suspend fun update(entity: TeamEntity)

    @Delete
    suspend fun delete(entity: TeamEntity)
}
