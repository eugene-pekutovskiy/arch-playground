package com.eugene.pekutovskyi.movies_list

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Top level view for {@link MoviesListBuilder.MoviesListScope}.
 */
class MoviesListView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle), MoviesListInteractor.MoviesListPresenter
