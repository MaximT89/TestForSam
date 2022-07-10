package com.max.secondworld.projectforsam.ui.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.max.secondworld.projectforsam.R
import com.max.secondworld.projectforsam.core.BaseFragment
import com.max.secondworld.projectforsam.core.playSingleSet
import com.max.secondworld.projectforsam.data.splash.ResponseData
import com.max.secondworld.projectforsam.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private val viewModel by viewModels<SplashViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObservers()
    }

    private fun initObservers() {
        viewModel.responseDataState.observe(viewLifecycleOwner){
            when(it){
                is SplashState.Success -> {
                    setFragmentResult("key1", bundleOf(
                        "data" to it.data
                    ))
                }
            }
        }
    }

    private fun initView() {

        val rotate = ObjectAnimator.ofFloat(binding.backLogo, View.ROTATION, 0f, 720f)

        val animatorSet = AnimatorSet().apply {
            duration = 3500
            play(rotate)
        }

        animatorSet.playSingleSet{
            findNavController().navigate(R.id.action_splashFragment_to_workFragment)
        }
    }
}