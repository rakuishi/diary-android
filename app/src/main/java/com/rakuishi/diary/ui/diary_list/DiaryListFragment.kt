package com.rakuishi.diary.ui.diary_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rakuishi.diary.databinding.FragmentDiaryListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryListFragment : Fragment() {

    companion object {

        fun createInstance(): DiaryListFragment {
            return DiaryListFragment()
        }
    }

    private var _binding: FragmentDiaryListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiaryListViewModel by viewModels()
    private lateinit var adapter: DiaryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiaryListBinding.inflate(inflater, container, false)
        bindView()
        subscribeUi()
        viewModel.getDiaries()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindView() {
        adapter = DiaryListAdapter {

        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.hasFixedSize()
    }

    private fun subscribeUi() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is DiaryListViewModel.UiState.Success -> {
                    adapter.submitList(it.response)
                }
                else -> {

                }
            }
        }
    }
}