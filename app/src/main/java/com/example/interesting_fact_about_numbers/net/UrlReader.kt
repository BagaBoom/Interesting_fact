package com.example.interesting_fact_about_numbers.net

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class UrlReader {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://numbersapi.com/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val apiService = retrofit.create(ApiService::class.java)

    suspend fun getTextFromUrl(url: String): String {
        return withContext(Dispatchers.IO) {
            apiService.getText(url)
        }
    }

    interface ApiService {
        @retrofit2.http.GET
        suspend fun getText(@retrofit2.http.Url url: String): String
    }
}
