package com.eugene.pekutovskyi.movies_list

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import timber.log.Timber

/**
 * Top level view for {@link MoviesListBuilder.MoviesListScope}.
 */
class MoviesListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle), MoviesListInteractor.MoviesListPresenter {

    override fun displayMoviesList(uiModels: List<MovieUiModel>) {
        Timber.d("display movies list")
    }
}
