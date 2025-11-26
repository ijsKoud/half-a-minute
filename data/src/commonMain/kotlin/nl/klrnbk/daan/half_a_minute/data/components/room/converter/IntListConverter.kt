package nl.klrnbk.daan.half_a_minute.data.components.room.converter

import androidx.room.TypeConverter

class IntListConverter {
    @TypeConverter
    fun fromIntList(list: List<Int>): String = list.joinToString(",")

    @TypeConverter
    fun toIntList(data: String): List<Int> =
        listOf(*data.split(",").map { it.toInt() }.toTypedArray())
}
