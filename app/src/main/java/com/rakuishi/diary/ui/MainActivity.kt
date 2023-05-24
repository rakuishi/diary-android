package com.rakuishi.diary.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rakuishi.diary.databinding.ActivityMainBinding
import com.rakuishi.diary.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeUi()
        viewModel.getDiaries()
    }

    private fun subscribeUi() {
        viewModel.uiState.observe(this) {
            when (it) {
                is MainViewModel.UiState.Success -> {
                    binding.textView.text = it.response.firstOrNull()?.title
                }
                else -> {

                }
            }
        }
    }
}