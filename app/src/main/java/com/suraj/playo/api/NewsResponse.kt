package com.suraj.playo.api

import com.suraj.playo.domain.Article

data class NewsResponse(
    val status: String,
    val totalResult: Int,
    val articles: List<Article>
) {
}