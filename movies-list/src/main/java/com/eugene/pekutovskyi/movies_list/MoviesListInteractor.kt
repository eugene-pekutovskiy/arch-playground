package com.eugene.pekutovskyi.movies_list

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [MoviesListScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class MoviesListInteractor :
    Interactor<MoviesListInteractor.MoviesListPresenter, MoviesListRouter>() {

    @Inject
    lateinit var presenter: MoviesListPresenter

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
    }

    override fun willResignActive() {
        super.willResignActive()
    }

    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface MoviesListPresenter
}
