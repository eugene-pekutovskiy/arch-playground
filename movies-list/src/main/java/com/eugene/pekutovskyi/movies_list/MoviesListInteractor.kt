package com.eugene.pekutovskyi.movies_list

import com.eugene.pekutovskyi.data.repository.MoviesRepository
import com.eugene.pekutovskyi.shared.SchedulersProvider
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.rxjava3.disposables.Disposable
import timber.log.Timber
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

    @Inject
    lateinit var moviesRepository: MoviesRepository

    @Inject
    lateinit var schedulersProvider: SchedulersProvider

    @Inject
    lateinit var popularMoviesToMovieUiModelMapper: PopularMoviesToMovieUiModelMapper

    private var disposable: Disposable? = null

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        disposable = moviesRepository.discoverPopularMovies()
            .map {
                it.results.map(popularMoviesToMovieUiModelMapper::map)
            }
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.main())
            .subscribe(
                presenter::displayMoviesList,
                Timber::e
            )
    }

    override fun willResignActive() {
        disposable?.dispose()
        super.willResignActive()
    }

    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface MoviesListPresenter {

        fun displayMoviesList(uiModels: List<MovieUiModel>)
    }
}
