package com.wax.tempocabocloapp.dependency_injection

import com.wax.tempocabocloapp.ui.fragments.home.HomeViewModel
import com.wax.tempocabocloapp.ui.fragments.location.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(weatherDataRepository = get()) }
    viewModel { LocationViewModel(weatherDataRepository = get()) }
}