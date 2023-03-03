package com.dev_akash.carousellnews.repo

import com.dev_akash.carousellnews.network.NewsApi
import javax.inject.Inject

open class NewsHomeRepo @Inject constructor(val newsApi: NewsApi) {

    suspend fun getNews() = newsApi.getNews()
}