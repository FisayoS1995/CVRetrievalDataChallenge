package com.pixelart.cvappchallenge.DI

import androidx.appcompat.app.AppCompatActivity
import com.pixelart.cvappchallenge.Network.NetworkService
import com.pixelart.cvappchallenge.ui.Presenter.HomeActivity
import com.pixelart.cvappchallenge.ui.Presenter.HomeContract
import com.pixelart.cvappchallenge.ui.Presenter.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (private val activity: AppCompatActivity){
    
    @Provides
    @ActivityScope
    fun providesHomePresenter(networkService: NetworkService): HomeContract.Presenter = HomePresenter(activity as HomeActivity, networkService)
}