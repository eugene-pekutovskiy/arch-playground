package com.eugene.pekutovskyi.movies_list

data class MovieUiModel(
    val title: String,
    val posterPath: String,
    val genreIds: List<Int>
)
