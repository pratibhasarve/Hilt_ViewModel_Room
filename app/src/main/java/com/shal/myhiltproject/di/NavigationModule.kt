package com.shal.myhiltproject.di

import com.shal.myhiltproject.navigator.INavigator
import com.shal.myhiltproject.navigator.NavigationImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {
    @Binds
    abstract fun bindNavigator(impl: NavigationImpl): INavigator
}