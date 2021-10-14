package com.eugene.pekutovskyi.data.repository

import com.eugene.pekutovskyi.data.TheMoviesDbApi
import com.eugene.pekutovskyi.data.model.PopularMoviesResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class TheMoviesDbRepository @Inject constructor(
    private val theMoviesDbApi: TheMoviesDbApi
) : MoviesRepository {

    override fun discoverPopularMovies(): Single<PopularMoviesResponse> =
        theMoviesDbApi.discoverPopularMovies(pageNumber = 1)
}
