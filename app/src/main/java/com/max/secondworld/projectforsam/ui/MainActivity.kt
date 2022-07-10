package com.max.secondworld.projectforsam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.max.secondworld.projectforsam.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}