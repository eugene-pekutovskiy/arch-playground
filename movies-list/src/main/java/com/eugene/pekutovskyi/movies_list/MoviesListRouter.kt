package com.eugene.pekutovskyi.movies_list

import android.view.View

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link MoviesListBuilder.MoviesListScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class MoviesListRouter(
    view: MoviesListView,
    interactor: MoviesListInteractor,
    component: MoviesListBuilder.Component) : ViewRouter<MoviesListView, MoviesListInteractor, MoviesListBuilder.Component>(view, interactor, component)
