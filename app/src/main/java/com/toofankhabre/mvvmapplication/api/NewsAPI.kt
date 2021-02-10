package com.toofankhabre.mvvmapplication.api

import com.toofankhabre.mvvmapplication.Response.NewsResponse
import com.toofankhabre.mvvmapplication.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("/v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("category")
        category: String = "business",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = Constants.API_KEY
    ): Response<NewsResponse>


    @GET("/v2/top-headlines")
    suspend fun searchForNews(
        @Query("country")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = Constants.API_KEY
    ): Response<NewsResponse>
}