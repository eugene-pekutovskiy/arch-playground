package com.eugene.pekutovskyi.archplayground

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 */
class RootRouter(
    view: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component
) : ViewRouter<RootView, RootInteractor>(view, interactor, component)
