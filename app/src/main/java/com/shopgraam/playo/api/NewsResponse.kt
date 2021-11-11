package com.shopgraam.playo.api

import com.shopgraam.playo.domain.Article

data class NewsResponse(
    val status: String,
    val totalResult: Int,
    val articles: List<Article>
) {
}