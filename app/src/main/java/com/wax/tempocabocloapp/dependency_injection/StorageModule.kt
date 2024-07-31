package com.wax.tempocabocloapp.dependency_injection

import com.wax.tempocabocloapp.storage.SharedPreferencesManager
import org.koin.dsl.module

val  storageModule = module {
    single { SharedPreferencesManager(context = get(), gson = get()) }

}