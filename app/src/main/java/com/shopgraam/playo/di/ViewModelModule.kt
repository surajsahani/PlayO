package com.shopgraam.playo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shopgraam.playo.NewsViewModel_Factory
import com.shopgraam.playo.di.base.ViewModelKey
import com.shopgraam.playo.ui.newslist.Action
import com.shopgraam.playo.ui.newslist.Change
import com.shopgraam.playo.repo.NewsRepository
import com.shopgraam.playo.ui.newslist.NewsViewModel
import com.shopgraam.playo.ui.newslist.State
import com.ww.roxie.BaseViewModel
import com.ww.roxie.Reducer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

import io.reactivex.rxkotlin.ofType
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@Module
abstract class ViewModelModule  {
    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    internal abstract fun bindNewsViewModel(newsViewModel: NewsViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: NewsViewModel_Factory):
            ViewModelProvider.Factory

}