package com.pixelart.cvappchallenge.DI

import com.pixelart.cvappchallenge.ui.Presenter.HomeActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    
    fun injectHomeScreen(homeActivity: HomeActivity)
}