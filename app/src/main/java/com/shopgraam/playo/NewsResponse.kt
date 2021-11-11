package com.shopgraam.playo

data class NewsResponse(
    val status: String,
    val totalResult: Int,
    val articles: List<Article>
) {
}