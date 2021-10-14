package com.eugene.pekutovskyi.data.model

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<PopularMovieData>,
    @SerializedName("total_pages")
    val total_pages: Int,
)
