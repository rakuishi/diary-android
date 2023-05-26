package com.rakuishi.diary.ui.diary_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rakuishi.diary.databinding.ListItemDiaryBinding
import com.rakuishi.diary.model.Diary

class DiaryViewHolder(
    private val binding: ListItemDiaryBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun create(parent: ViewGroup): DiaryViewHolder {
            return DiaryViewHolder(
                ListItemDiaryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(diary: Diary, onClickDiary: (Diary) -> Unit) {
        binding.root.setOnClickListener { onClickDiary(diary) }
        binding.titleTextView.text = diary.title
    }
}
