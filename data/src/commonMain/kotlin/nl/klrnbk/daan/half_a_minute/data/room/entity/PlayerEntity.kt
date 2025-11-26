package nl.klrnbk.daan.half_a_minute.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
@Entity("player")
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true) val id: Uuid,
    val teamId: Uuid?,
    val gameId: Uuid,
    val name: String
)
