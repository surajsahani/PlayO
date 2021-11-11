package com.suraj.playo.domain

import javax.xml.transform.Source

/*
Domain model for article
 */
data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
