package com.eugene.pekutovskyi.movies_list

import com.uber.rib.core.ViewRouter

class MoviesListRouter(
    view: MoviesListView,
    interactor: MoviesListInteractor,
    component: MoviesListBuilder.Component
) : ViewRouter<MoviesListView, MoviesListInteractor>(view, interactor, component)
