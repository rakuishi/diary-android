package com.rakuishi.diary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakuishi.diary.data.DiaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
) : ViewModel() {

    fun getDiaries() {
        viewModelScope.launch {
            diaryRepository.getDiaries()
        }
    }
}