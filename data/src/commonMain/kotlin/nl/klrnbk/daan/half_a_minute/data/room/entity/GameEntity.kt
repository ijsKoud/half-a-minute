package nl.klrnbk.daan.half_a_minute.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import nl.klrnbk.daan.half_a_minute.domain.game.model.GameStatus

@Entity
data class GameEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val status: GameStatus,
    val hostId: Long
)
