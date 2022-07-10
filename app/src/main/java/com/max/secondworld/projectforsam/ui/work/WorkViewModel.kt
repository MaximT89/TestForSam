package com.max.secondworld.projectforsam.ui.work

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.max.secondworld.projectforsam.data.splash.ResponseData
import com.max.secondworld.projectforsam.ui.splash.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkViewModel @Inject constructor() : ViewModel() {

    private var _workState = MutableLiveData<WorkState>()
    val workState: LiveData<WorkState> = _workState

    fun updateWorkData(data : ResponseData){
        _workState.value = WorkState.Success(data)
    }
}

sealed class WorkState {
    class Success(val data : ResponseData) : WorkState()
}
