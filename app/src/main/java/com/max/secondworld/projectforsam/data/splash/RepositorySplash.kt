package com.max.secondworld.projectforsam.data.splash

import javax.inject.Inject

class RepositorySplash @Inject constructor(private val apiServiceSplash: ApiServiceSplash) {

    suspend fun fetchData() = apiServiceSplash.getData()
}