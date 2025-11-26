package nl.klrnbk.daan.half_a_minute.data.components.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.GameStatus

@OptIn(ExperimentalUuidApi::class)
@Entity("game")
data class GameEntity(
    @PrimaryKey(autoGenerate = true) val id: Uuid,
    val status: GameStatus,
    val hostId: Long
)
