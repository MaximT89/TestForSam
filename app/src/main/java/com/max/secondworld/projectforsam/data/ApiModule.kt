package com.max.secondworld.projectforsam.data

import com.max.secondworld.projectforsam.data.splash.ApiServiceSplash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideBaseUrl() = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideRetrofitClient(baseUrl : String) : Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApiServiceSplash(retrofit: Retrofit) : ApiServiceSplash =
        retrofit.create(ApiServiceSplash::class.java)
}