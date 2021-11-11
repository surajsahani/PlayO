package com.shopgraam.playo

import android.app.Activity
import android.app.Application
import com.shopgraam.playo.di.base.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class NewsApp: Application(), HasAndroidInjector  {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        TODO("Not yet implemented")
    }


}