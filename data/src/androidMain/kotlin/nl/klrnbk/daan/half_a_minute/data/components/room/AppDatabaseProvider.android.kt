package nl.klrnbk.daan.half_a_minute.data.components.room

import androidx.room.Room
import androidx.room.RoomDatabase
import nl.klrnbk.daan.half_a_minute.data.components.room.AppDatabase
import nl.klrnbk.daan.half_a_minute.data.components.room.AppDatabaseConfig
import nl.klrnbk.daan.half_a_minute.data.context.ContextWrapper
import nl.klrnbk.daan.half_a_minute.data.di.qualifiers.LocalAppDatabaseConfig
import org.koin.core.annotation.Single

@Single
actual class AppDatabaseProvider(
    private val contextWrapper: ContextWrapper,
    @LocalAppDatabaseConfig private val appDatabaseConfig: AppDatabaseConfig
) {
    actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        val appContext = contextWrapper.get().applicationContext
        val dbFile = appContext.getDatabasePath(appDatabaseConfig.localDbName)
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}
