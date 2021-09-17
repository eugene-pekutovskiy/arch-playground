package com.eugene.pekutovskyi.movies_list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link MoviesListScope}.
 */
class MoviesListBuilder(
    dependency: ParentComponent
) : ViewBuilder<MoviesListView, MoviesListRouter, MoviesListBuilder.ParentComponent>(dependency) {

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
        return component.moviesListRouter()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        parentViewGroup: ViewGroup
    ): MoviesListView = inflater.inflate(
        R.layout.movies_list_view, parentViewGroup, false
    ) as MoviesListView

    @Suppress("RemoveEmptyClassBody")
    interface ParentComponent {

    }

    @dagger.Module
    abstract class Module {

        @MoviesListScope
        @Binds
        internal abstract fun presenter(
            view: MoviesListView
        ): MoviesListInteractor.MoviesListPresenter

        @dagger.Module
        companion object {

            @MoviesListScope
            @Provides
            @JvmStatic
            internal fun router(
                component: Component,
                view: MoviesListView,
                interactor: MoviesListInteractor
            ): MoviesListRouter {
                return MoviesListRouter(view, interactor, component)
            }
        }

    }

    @MoviesListScope
    @dagger.Component(
        modules = [Module::class],
        dependencies = [ParentComponent::class]
    )
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
        fun moviesListRouter(): MoviesListRouter
    }

    @Scope
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    internal annotation class MoviesListScope

    @Qualifier
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    internal annotation class MoviesListInternal
}
