package com.eugene.pekutovskyi.archplayground

import android.app.Application
import com.eugene.pekutovskyi.data.NetworkModule
import timber.log.Timber

class MoviesApplication : Application() {

    lateinit var applicationComponent: MoviesApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerMoviesApplicationComponent.builder()
            .networkModule(NetworkModule())
            .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}