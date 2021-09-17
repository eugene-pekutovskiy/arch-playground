package com.eugene.pekutovskyi.movies_list

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MoviesListRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: MoviesListBuilder.Component
  @Mock internal lateinit var interactor: MoviesListInteractor
  @Mock internal lateinit var view: MoviesListView

  private var router: MoviesListRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = MoviesListRouter(view, interactor, component)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}

