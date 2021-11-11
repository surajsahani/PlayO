package com.shopgraam.playo.di

import com.shopgraam.playo.api.NewsService
import com.shopgraam.playo.utils.create
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


