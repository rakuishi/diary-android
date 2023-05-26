package com.rakuishi.diary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rakuishi.diary.R
import com.rakuishi.diary.databinding.ActivityMainBinding
import com.rakuishi.diary.ui.diary_list.DiaryListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindView()
    }

    private fun bindView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DiaryListFragment.createInstance())
            .addToBackStack(null)
            .commit()
    }
}