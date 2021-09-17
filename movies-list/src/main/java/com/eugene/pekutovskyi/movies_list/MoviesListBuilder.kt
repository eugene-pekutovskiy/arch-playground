package com.eugene.pekutovskyi.movies_list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link MoviesListScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class MoviesListBuilder(dependency: ParentComponent) : ViewBuilder<MoviesListView, MoviesListRouter, MoviesListBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [MoviesListRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [MoviesListRouter].
   */
  fun build(parentViewGroup: ViewGroup): MoviesListRouter {
    val view = createView(parentViewGroup)
    val interactor = MoviesListInteractor()
    val component = DaggerMoviesListBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.movieslistRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): MoviesListView? {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return null
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @MoviesListScope
    @Binds
    internal abstract fun presenter(view: MoviesListView): MoviesListInteractor.MoviesListPresenter

    @dagger.Module
    companion object {

      @MoviesListScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: MoviesListView,
          interactor: MoviesListInteractor): MoviesListRouter {
        return MoviesListRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @MoviesListScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<MoviesListInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: MoviesListInteractor): Builder

      @BindsInstance
      fun view(view: MoviesListView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun movieslistRouter(): MoviesListRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class MoviesListScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class MoviesListInternal
}
