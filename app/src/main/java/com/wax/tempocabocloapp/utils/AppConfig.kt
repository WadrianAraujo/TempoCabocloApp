package com.wax.tempocabocloapp.utils

import android.app.Application
import com.wax.tempocabocloapp.dependency_injection.repositoryModule
import com.wax.tempocabocloapp.dependency_injection.viewModelModule
import org.koin.core.context.startKoin

class AppConfig : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(repositoryModule, viewModelModule))
        }
    }
}