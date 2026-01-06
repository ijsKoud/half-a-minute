package nl.klrnbk.daan.half_a_minute.data.components.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.GameStatus

@Entity("game")
data class GameEntity(
    @PrimaryKey val id: Uuid,
    val pointsGoal: Int,
    val wordsPerRound: Int,
    val status: GameStatus,
    val hostId: Uuid?
)
