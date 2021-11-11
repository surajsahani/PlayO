package com.suraj.playo.di

import com.suraj.playo.NewsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule  {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): NewsActivity
}