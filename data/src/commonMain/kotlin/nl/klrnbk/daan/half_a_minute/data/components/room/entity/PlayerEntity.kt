package nl.klrnbk.daan.half_a_minute.data.components.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.Uuid

@Entity("player")
data class PlayerEntity(
    @PrimaryKey val id: Uuid,
    val teamId: Uuid?,
    val gameId: Uuid,
    val name: String
)
