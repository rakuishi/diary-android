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

            list.add(
                Diary(
                    id = 1L,
                    title = "｢タコの心身問題｣を読んだ",
                    image = Image(
                        id = 1L,
                        imageUrl = "https://rakuishi.com/images/2019/08/the-octopus-the-sea-and-the-deep-origins-of-consciousness.jpg",
                    )
                )
            )

            list.add(
                Diary(
                    id = 2L,
                    title = "悲鳴の連鎖の上に立っている",
                    image = null
                )
            )

            list.add(
                Diary(
                    id = 3L,
                    title = "どうにかして脳の神経伝達物質を御したい",
                    image = null
                )
            )

            list
        }
    }
}