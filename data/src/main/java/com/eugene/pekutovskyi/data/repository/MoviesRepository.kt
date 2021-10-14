package com.eugene.pekutovskyi.data.repository

import com.eugene.pekutovskyi.data.model.PopularMoviesResponse
import io.reactivex.rxjava3.core.Single

interface MoviesRepository {

    fun discoverPopularMovies(): Single<PopularMoviesResponse>

}
