package com.rakuishi.diary.data

import com.rakuishi.diary.model.Diary
import com.rakuishi.diary.model.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DiaryRepository {

    suspend fun getDiaries(): List<Diary> {
        // FIXME: Currently return dummy data
        return withContext(Dispatchers.IO) {
            val list = mutableListOf<Diary>()

            val image = Image(
                id = 1L,
                imageUrl = "https://rakuishi.com/images/2019/08/the-octopus-the-sea-and-the-deep-origins-of-consciousness.jpg",
            )
            val diary = Diary(
                id = 1L,
                title = "｢タコの心身問題｣を読んだ",
                image = image
            )
            list.add(diary)

            list
        }
    }
}