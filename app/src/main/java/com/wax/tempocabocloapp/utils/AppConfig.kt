package com.wax.tempocabocloapp.utils

import android.app.Application
import com.wax.tempocabocloapp.dependency_injection.networkModule
import com.wax.tempocabocloapp.dependency_injection.repositoryModule
import com.wax.tempocabocloapp.dependency_injection.serializerModule
import com.wax.tempocabocloapp.dependency_injection.storageModule
import com.wax.tempocabocloapp.dependency_injection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppConfig : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppConfig)
            modules(
                listOf
                    (
                    repositoryModule,
                    viewModelModule,
                    serializerModule,
                    storageModule,
                    networkModule
                )
            )
        }
    }
}