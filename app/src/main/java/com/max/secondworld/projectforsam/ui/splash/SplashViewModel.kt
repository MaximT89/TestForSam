package com.max.secondworld.projectforsam.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.secondworld.projectforsam.data.splash.RepositorySplash
import com.max.secondworld.projectforsam.data.splash.ResponseData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: RepositorySplash) : ViewModel() {

    private var _responseDataState = MutableLiveData<SplashState>()
    val responseDataState: LiveData<SplashState> = _responseDataState

    init{
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.fetchData()
            if (response.isSuccessful) {
                val body = response.body()
                _responseDataState.postValue(SplashState.Success(body!!))
            }
        }
    }
}

sealed class SplashState {
    class Success(val data : ResponseData) : SplashState()
}
