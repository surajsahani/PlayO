package com.shopgraam.playo

import com.ww.roxie.BaseViewModel
import com.ww.roxie.Reducer

import io.reactivex.rxkotlin.ofType
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


class NewsViewModel @Inject constructor(
    private  val newsRepository: NewsRepository
) : BaseViewModel<Action, State>()  {

    override val initialState = State.Loading

    private val reducer:Reducer<State, Change> = {_, change ->
        when (change) {
            is Change.News -> State.News(change.news)
            is Change.Loading -> State.Loading
            is Change.Error -> State.Error

        }
    }

    init {
        bindAction()
    }

    private fun bindAction () {
        val loadNews = actions.ofType<Action.LoadNews>()
            .switchMap {
                newsRepository.getTopHeadlines("technology")
                    .subscribeOn(Schedulers.io())
                    .map<Change> {Change.News(it.articles)}
                    .onErrorReturn{ Change.Error}
                    .startWith(Change.Loading)
            }

        disposables += loadNews
            .scan(initialState, reducer)
            .distinctUntilChanged()
            .subscribe(state::postValue, Timber::e)
    }

}