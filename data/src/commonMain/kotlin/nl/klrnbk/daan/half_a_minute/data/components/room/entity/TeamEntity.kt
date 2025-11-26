package nl.klrnbk.daan.half_a_minute.data.components.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.TeamName

@Entity("team")
data class TeamEntity(
    @PrimaryKey val id: Uuid,
    val gameId: Uuid,
    val name: TeamName,
    val pointsPerRound: List<Int>
)
