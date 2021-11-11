package com.suraj.playo.ui.newslist

import com.suraj.playo.domain.Article
import com.ww.roxie.BaseState

sealed class State : BaseState {

    data class News(
        val news: List<Article>
    ) : State()

    object Loading : State()

    object Error : State()
}
