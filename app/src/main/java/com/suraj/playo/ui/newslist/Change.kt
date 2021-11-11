package com.suraj.playo.ui.newslist

import com.suraj.playo.domain.Article

sealed class Change {

    data class News(val news: List<Article>) : Change()

    object Loading : Change()

    object Error : Change()
}