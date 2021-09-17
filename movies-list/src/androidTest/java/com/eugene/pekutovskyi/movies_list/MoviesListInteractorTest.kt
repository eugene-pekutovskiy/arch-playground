package com.eugene.pekutovskyi.movies_list

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MoviesListInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: MoviesListInteractor.MoviesListPresenter
  @Mock internal lateinit var router: MoviesListRouter

  private var interactor: MoviesListInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestMoviesListInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<MoviesListInteractor.MoviesListPresenter, MoviesListRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}