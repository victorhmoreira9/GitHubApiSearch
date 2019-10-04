package com.example.android.agilecontenttest.service

import com.example.android.agilecontenttest.models.UserRepositoryList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface RestApiService {

    @GET("/users/{username}/repos")
    fun getUser(@Path("username") id: String): Call<List<UserRepositoryList>>

}
