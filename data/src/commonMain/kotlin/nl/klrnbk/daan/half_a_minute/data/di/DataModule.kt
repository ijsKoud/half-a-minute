package nl.klrnbk.daan.half_a_minute.data.di

import nl.klrnbk.daan.half_a_minute.data.components.example.di.ExampleModule
import nl.klrnbk.daan.half_a_minute.data.config.ApiConfig
import nl.klrnbk.daan.half_a_minute.data.config.DataConfig
import nl.klrnbk.daan.half_a_minute.data.context.ContextWrapper
import nl.klrnbk.daan.half_a_minute.data.di.qualifiers.ExampleApiConfig
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.dsl.module

@Module(
    includes = [
        ExampleModule::class,
    ],
)
@ComponentScan("nl.klrnbk.daan.half_a_minute.data")
class DataModule {

    @Single
    @ExampleApiConfig
    fun provideExampleApiConfig(): ApiConfig {
        return ApiConfig(DataConfig.EXAMPLE_API_BASE_URL)
    }
}

fun contextModule(context: ContextWrapper) = module { factory { context } }
