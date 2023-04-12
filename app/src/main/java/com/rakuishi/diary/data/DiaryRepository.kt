package com.rakuishi.diary.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class DiaryRepository {

    suspend fun getDiaries() {
        return withContext(Dispatchers.IO) {
            Timber.d("DiaryRepository#getDiaries")
        }
    }
}