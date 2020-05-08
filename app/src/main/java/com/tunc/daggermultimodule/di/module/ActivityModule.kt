package com.tunc.daggermultimodule.di.module

import com.tunc.daggermultimodule.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun main(): MainActivity
}