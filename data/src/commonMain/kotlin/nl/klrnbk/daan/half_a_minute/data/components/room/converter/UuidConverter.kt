package nl.klrnbk.daan.half_a_minute.data.components.room.converter

import androidx.room.TypeConverter
import kotlin.uuid.Uuid

class UuidConverter {
    @TypeConverter
    fun fromUUID(uuid: Uuid): String = uuid.toString()

    @TypeConverter
    fun uuidFromString(string: String): Uuid = Uuid.parse(string)
}
