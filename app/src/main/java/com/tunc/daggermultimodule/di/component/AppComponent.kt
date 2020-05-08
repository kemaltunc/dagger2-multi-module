package com.tunc.daggermultimodule.di.component

import com.tunc.daggermultimodule.App
import com.tunc.daggermultimodule.di.module.ActivityModule
import com.tunc.daggermultimodule.di.scope.AppScope
import com.tunc.networkmodule.component.NetworkComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule


@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class],
    dependencies = [NetworkComponent::class]
)
@AppScope
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun networkComponent(networkComponent: NetworkComponent): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)
}