package com.tunc.networkmodule.component

import com.tunc.networkmodule.module.NetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


@Singleton
@Component(
    modules = [NetworkModule::class]
)
interface NetworkComponent {
    @Component.Builder
    interface Builder {
        fun build(): NetworkComponent
    }

    fun getRetrofit(): Retrofit
}