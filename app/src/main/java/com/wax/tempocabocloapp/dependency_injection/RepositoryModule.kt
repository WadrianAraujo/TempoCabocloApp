package com.wax.tempocabocloapp.dependency_injection

import com.wax.tempocabocloapp.network.repository.WeatherDataRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherDataRepository(weatherAPI = get()) }
}