package nl.klrnbk.daan.half_a_minute.data.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import nl.klrnbk.daan.half_a_minute.data.room.converter.GameEntityConverters

@Database(
    entities = [],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
@TypeConverters(GameEntityConverters::class)
abstract class AppDatabase : RoomDatabase()

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}
