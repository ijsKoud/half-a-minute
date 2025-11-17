package nl.klrnbk.daan.half_a_minute.presentation.di

import nl.klrnbk.daan.half_a_minute.data.di.DataModule
import nl.klrnbk.daan.half_a_minute.domain.di.DomainModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    includes = [
        DomainModule::class,
        DataModule::class,
    ],
)
@ComponentScan("nl.klrnbk.daan.half_a_minute.presentation")
class AppModule
