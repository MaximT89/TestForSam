package com.max.secondworld.projectforsam.core

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val END_DELAY = 1000

fun List<AnimatorSet>.playAllSets(coroutineScope: CoroutineScope, end : () -> Unit){
    coroutineScope.launch(Dispatchers.Main){
        for(animSet in this@playAllSets){
            animSet.start()
            delay(animSet.duration)
        }
        delay(END_DELAY.toLong())
        end.invoke()
    }
}

fun AnimatorSet.playSingleSet(end : () -> Unit) {
    apply {
        start()
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                end.invoke()
            }
        })
    }
}