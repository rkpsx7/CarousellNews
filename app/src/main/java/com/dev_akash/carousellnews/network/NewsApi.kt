package com.dev_akash.carousellnews.network

import com.dev_akash.carousellnews.model.NewsHomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {

    //https://storage.googleapis.com/carousell-interview-assets/android/carousell_news.json

    @GET("carousell-interview-assets/android/carousell_news.json")
    suspend fun getNews():Response<List<NewsHomeResponse>>
}