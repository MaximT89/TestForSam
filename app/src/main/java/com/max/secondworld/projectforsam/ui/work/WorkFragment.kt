package com.max.secondworld.projectforsam.ui.work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.max.secondworld.projectforsam.R
import com.max.secondworld.projectforsam.core.BaseFragment
import com.max.secondworld.projectforsam.data.splash.ResponseData
import com.max.secondworld.projectforsam.databinding.FragmentWorkBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkFragment : BaseFragment<FragmentWorkBinding>(FragmentWorkBinding::inflate) {

    private val viewModel by viewModels<WorkViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initObservers()
    }

    private fun initListeners() {
        setFragmentResultListener("key1") { _, bundle ->
            val responseData = bundle.getParcelable<ResponseData>("data")
            if (responseData != null){
                viewModel.updateWorkData(responseData)
            }
        }
    }

    private fun initObservers() {
        viewModel.workState.observe(viewLifecycleOwner){
            when(it){
                is WorkState.Success -> updateUi(it.data)
            }
        }
    }

    private fun updateUi(data: ResponseData) = with(binding){
        userId.text = data.userId.toString()
        title.text = data.title
    }
}