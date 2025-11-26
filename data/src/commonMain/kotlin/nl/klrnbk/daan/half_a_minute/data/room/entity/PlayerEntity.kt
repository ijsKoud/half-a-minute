package nl.klrnbk.daan.half_a_minute.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val teamId: Long?,
    val gameId: Long,
    val name: String
)
