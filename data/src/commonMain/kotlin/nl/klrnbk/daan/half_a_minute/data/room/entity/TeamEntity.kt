package nl.klrnbk.daan.half_a_minute.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.TeamName

@OptIn(ExperimentalUuidApi::class)
@Entity("team")
data class TeamEntity(
    @PrimaryKey(autoGenerate = true) val id: Uuid,
    val gameId: Uuid,
    val name: TeamName,
    val pointsPerRound: List<Int>
)
