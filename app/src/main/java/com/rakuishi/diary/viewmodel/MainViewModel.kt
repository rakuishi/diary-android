package com.rakuishi.diary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakuishi.diary.data.DiaryRepository
import com.rakuishi.diary.model.Diary
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
) : ViewModel() {

    sealed class UiState<out T> {
        object Loading : UiState<Nothing>()
        data class Failure(val throwable: Throwable?) : UiState<Nothing>()
        data class Success<T>(val response: T) : UiState<T>()
    }

    private val _uiState: MutableLiveData<UiState<List<Diary>>> = MutableLiveData(UiState.Loading)
    val uiState: LiveData<UiState<List<Diary>>> = _uiState

    fun getDiaries() {
        viewModelScope.launch {
            val diaries = diaryRepository.getDiaries()
            _uiState.postValue(UiState.Success(diaries))
        }
    }
}