package com.shopgraam.playo

sealed class Change {

    data class News(val news: List<Article>) : Change()

    object Loading : Change()

    object Error : Change()
}