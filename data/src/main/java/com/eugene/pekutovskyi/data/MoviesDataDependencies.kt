package com.eugene.pekutovskyi.data

import com.eugene.pekutovskyi.data.repository.MoviesRepository
import com.eugene.pekutovskyi.data.repository.TheMoviesDbRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
abstract class MoviesDataDependencies {

    @Binds
    abstract fun bindsMoviesRepository(
        moviesRepository: TheMoviesDbRepository
    ): MoviesRepository
}