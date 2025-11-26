package nl.klrnbk.daan.half_a_minute.data.room.converter

import androidx.room.TypeConverter
import nl.klrnbk.daan.half_a_minute.domain.game.model.GameStatus

class GameEntityConverters {
    @TypeConverter
    fun fromGameStatus(value: GameStatus): String = value.name

    @TypeConverter
    fun toGameStatus(value: String): GameStatus = enumValueOf<GameStatus>(value)
}
