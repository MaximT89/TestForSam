package com.max.secondworld.projectforsam.data.splash

import retrofit2.Response
import retrofit2.http.GET

interface ApiServiceSplash {

    @GET("/todos/1")
    suspend fun getData() : Response<ResponseData>
}