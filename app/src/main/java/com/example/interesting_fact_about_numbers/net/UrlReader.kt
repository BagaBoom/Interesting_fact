package com.example.interesting_fact_about_numbers.net



import kotlinx.coroutines.*

import retrofit2.Retrofit

import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path




class UrlReader {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://numbersapi.com")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val apiService = retrofit.create(ApiService::class.java)

    suspend fun getTextFromUrl(url: String): String {
        return withContext(Dispatchers.IO) {
            apiService.getText(url)
        }
    }

    interface ApiService {
        @GET("{url}")
        suspend fun getText(@Path("url") url: String): String
    }
}




