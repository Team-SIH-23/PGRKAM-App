package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.pgrkam_app.databinding.FragmentSkillDevelopmentBinding
import com.assignment.pgrkam_app.ui.adapter.RecommendationAdapter
import com.assignment.pgrkam_app.viewmodels.RecommendationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SkillDevelopmentFragment : Fragment() {

    private lateinit var binding: FragmentSkillDevelopmentBinding

    private lateinit var viewModel: RecommendationViewModel
    private lateinit var recommendationAdapter: RecommendationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSkillDevelopmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[RecommendationViewModel::class.java]
        recommendationAdapter = RecommendationAdapter()
        binding.rvRecommendation.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recommendationAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRecommendedJobs()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.recommendationUiState.collect {
                    recommendationAdapter.setRecommendationResponseItemList(it)
                }
            }
        }
    }
}