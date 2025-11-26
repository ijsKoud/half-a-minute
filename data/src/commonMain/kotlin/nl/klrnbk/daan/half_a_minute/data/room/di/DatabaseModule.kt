package nl.klrnbk.daan.half_a_minute.data.room.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import nl.klrnbk.daan.half_a_minute.data.config.DataConfig
import nl.klrnbk.daan.half_a_minute.data.di.qualifiers.LocalAppDatabaseConfig
import nl.klrnbk.daan.half_a_minute.data.room.AppDatabase
import nl.klrnbk.daan.half_a_minute.data.room.AppDatabaseConfig
import nl.klrnbk.daan.half_a_minute.data.room.AppDatabaseProvider
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class DatabaseModule {
    @Single
    @LocalAppDatabaseConfig
    fun provideAppDatabaseConfig(): AppDatabaseConfig =
        AppDatabaseConfig(localDbName = DataConfig.LOCAL_DB_NAME)

    @Single
    fun provideAppDatabase(appDatabaseProvider: AppDatabaseProvider): AppDatabase =
        appDatabaseProvider.getDatabaseBuilder()
            .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
}
