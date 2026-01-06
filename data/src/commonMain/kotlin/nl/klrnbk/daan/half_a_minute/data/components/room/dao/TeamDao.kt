package nl.klrnbk.daan.half_a_minute.data.components.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.relations.TeamWithPlayersRelation
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.TeamEntity

@Dao
interface TeamDao {
    @Transaction
    @Query("SELECT * FROM team WHERE team.id = :id")
    suspend fun getById(id: Uuid): TeamWithPlayersRelation?

    @Insert
    suspend fun insert(entity: TeamEntity)

    @Transaction
    @Query("DELETE FROM team WHERE team.id = :id")
    suspend fun deleteById(id: Uuid)

    @Transaction
    @Query("UPDATE team SET pointsPerRound = :pointsPerRound WHERE team.id = :id")
    suspend fun updatePointsPerRound(id: Uuid, pointsPerRound: List<Int>)
}
