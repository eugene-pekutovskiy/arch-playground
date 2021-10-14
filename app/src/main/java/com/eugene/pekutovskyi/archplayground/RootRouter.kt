package com.eugene.pekutovskyi.archplayground

import com.eugene.pekutovskyi.movies_list.MoviesListBuilder
import com.eugene.pekutovskyi.movies_list.MoviesListRouter
import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 */
class RootRouter(
    rootView: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component,
    private val moviesListBuilder: MoviesListBuilder
) : ViewRouter<RootView, RootInteractor>(rootView, interactor, component) {

    private var moviesListRouter: MoviesListRouter? = null

    fun attachMoviesList() {
        val router = moviesListBuilder.build(view)
        attachChild(router)
        view.addView(router.view)
        moviesListRouter = router
    }
}
