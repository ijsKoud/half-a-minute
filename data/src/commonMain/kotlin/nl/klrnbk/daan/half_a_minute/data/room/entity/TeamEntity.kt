package nl.klrnbk.daan.half_a_minute.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import nl.klrnbk.daan.half_a_minute.domain.game.model.TeamName

@Entity
data class TeamEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val gameId: Long,
    val name: TeamName,
    val pointsPerRound: List<Int>
)
