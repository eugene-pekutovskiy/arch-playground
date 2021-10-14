package com.eugene.pekutovskyi.movies_list

import com.eugene.pekutovskyi.data.model.PopularMovieData
import javax.inject.Inject

class PopularMoviesToMovieUiModelMapper @Inject constructor() {

    fun map(movieData: PopularMovieData) = MovieUiModel(
        title = movieData.original_title,
        posterPath = movieData.poster_path,
        genreIds = movieData.genre_ids
    )
}
