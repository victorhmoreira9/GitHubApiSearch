package com.example.android.agilecontenttest.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiBuilder {

    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    companion object {

        val BASE_URL = "https://api.github.com"
        fun getService(restApiBuilder: RestApiBuilder): RestApiService {
            return restApiBuilder.retrofit.create(RestApiService::class.java)
        }
    }
}