package nl.klrnbk.daan.half_a_minute.data.room

import androidx.room.RoomDatabase

expect class AppDatabaseProvider {
    fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>
}
