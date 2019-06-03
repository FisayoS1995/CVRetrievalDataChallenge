package com.pixelart.cvappchallenge.DI

import dagger.Component

@ApplicationScope
@Component(modules = [NetworkModule::class])
interface ApplicationComponent{
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
}