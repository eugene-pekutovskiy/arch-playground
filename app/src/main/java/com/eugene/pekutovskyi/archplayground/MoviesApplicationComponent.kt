package com.eugene.pekutovskyi.archplayground

import com.eugene.pekutovskyi.data.MoviesDataDependencies
import com.eugene.pekutovskyi.data.repository.MoviesRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MoviesDataDependencies::class])
interface MoviesApplicationComponent : RootBuilder.ParentComponent {
    fun moviesRepository(): MoviesRepository
}
