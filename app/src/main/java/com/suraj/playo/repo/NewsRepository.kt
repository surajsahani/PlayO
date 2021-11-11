package com.suraj.playo.repo

import com.suraj.playo.api.NewsService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val newsService: NewsService
) {
    fun getTopHeadlines(category: String) = newsService.getTopHeadlines(category)
}