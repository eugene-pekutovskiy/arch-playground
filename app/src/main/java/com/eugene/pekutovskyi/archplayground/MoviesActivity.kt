package com.eugene.pekutovskyi.archplayground

import android.view.ViewGroup
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class MoviesActivity : RibActivity() {

    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *> {
        val applicationComponent = (application as MoviesApplication).applicationComponent
        return RootBuilder(applicationComponent)
            .build(parentViewGroup)
    }
}
