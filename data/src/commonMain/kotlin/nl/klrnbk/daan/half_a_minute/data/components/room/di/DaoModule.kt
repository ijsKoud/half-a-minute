package nl.klrnbk.daan.half_a_minute.data.components.room.di

import nl.klrnbk.daan.half_a_minute.data.components.room.AppDatabase
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.GameDao
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.PlayerDao
import nl.klrnbk.daan.half_a_minute.data.components.room.dao.TeamDao
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class DaoModule {
    @Single
    fun provideGameDao(appDatabase: AppDatabase): GameDao = appDatabase.gameDao()

    @Single
    fun providePlayerDao(appDatabase: AppDatabase): PlayerDao = appDatabase.playerDao()

    @Single
    fun provideTeamDao(appDatabase: AppDatabase): TeamDao = appDatabase.teamDao()
}
