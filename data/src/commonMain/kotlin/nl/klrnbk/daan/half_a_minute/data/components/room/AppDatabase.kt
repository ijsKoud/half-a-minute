package nl.klrnbk.daan.half_a_minute.data.components.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import nl.klrnbk.daan.half_a_minute.data.components.room.converter.GameStatusConverter
import nl.klrnbk.daan.half_a_minute.data.components.room.converter.IntListConverter
import nl.klrnbk.daan.half_a_minute.data.components.room.converter.UuidConverter
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.GameDao
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.PlayerDao
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.TeamDao
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.GameEntity
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.PlayerEntity
import nl.klrnbk.daan.half_a_minute.data.components.room.entity.TeamEntity

@Database(
    entities = [GameEntity::class, TeamEntity::class, PlayerEntity::class],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
@TypeConverters(GameStatusConverter::class, UuidConverter::class, IntListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
    abstract fun playerDao(): PlayerDao
    abstract fun teamDao(): TeamDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}
