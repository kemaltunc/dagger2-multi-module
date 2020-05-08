package com.tunc.daggermultimodule

import android.app.Activity
import android.app.Application
import com.tunc.daggermultimodule.di.component.DaggerAppComponent
import com.tunc.networkmodule.component.DaggerNetworkComponent
import com.tunc.networkmodule.component.NetworkComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            .networkComponent(networkComponent)
            .build()
            .inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector


    private val networkComponent: NetworkComponent by lazy {
        DaggerNetworkComponent
            .builder()
            .build()
    }


}