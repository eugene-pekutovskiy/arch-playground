package com.eugene.pekutovskyi.data

import com.eugene.pekutovskyi.data.model.PopularMoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMoviesDbApi {

    @GET("discover/movie?sort_by=popularity.desc")
    fun discoverPopularMovies(@Query("page") pageNumber: Int): Single<PopularMoviesResponse>
}
