package com.suraj.playo.di

import com.suraj.playo.api.NewsService
import com.suraj.playo.utils.create
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): NewsService = retrofit.create()
}


