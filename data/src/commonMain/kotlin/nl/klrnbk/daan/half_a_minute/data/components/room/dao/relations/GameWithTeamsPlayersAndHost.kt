package nl.klrnbk.daan.half_a_minute.data.components.room.dao.relations

import androidx.room.Embedded
import androidx.room.Relation
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.GameEntity
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.PlayerEntity
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.TeamEntity

data class GameWithTeamsPlayersAndHost(
    @Embedded val game: GameEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "gameId"
    )
    val players: List<PlayerEntity>,

    @Relation(
        parentColumn = "hostId",
        entityColumn = "id"
    )
    val host: PlayerEntity?,

    @Relation(
        entity = TeamEntity::class,
        parentColumn = "id",
        entityColumn = "gameId"
    )
    val teams: List<TeamWithPlayersRelation>
)
