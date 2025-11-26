package nl.klrnbk.daan.half_a_minute.data.room.dao.relations

import androidx.room.Embedded
import androidx.room.Relation
import nl.klrnbk.daan.half_a_minute.data.room.entity.PlayerEntity
import nl.klrnbk.daan.half_a_minute.data.room.entity.TeamEntity

data class TeamWithPlayersRelation(
    @Embedded val team: TeamEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "teamId"
    )
    val players: List<PlayerEntity>
)
