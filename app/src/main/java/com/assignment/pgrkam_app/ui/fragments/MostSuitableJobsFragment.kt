package com.assignment.pgrkam_app.ui.fragments

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.pgrkam_app.R
import com.assignment.pgrkam_app.databinding.FragmentMostSuitableJobsBinding
import com.assignment.pgrkam_app.models.GovtJobs
import com.assignment.pgrkam_app.ui.adapter.MostSuitableJobsAdapter
import com.assignment.pgrkam_app.ui.adapter.RecommendationAdapter
import com.assignment.pgrkam_app.utils.GovtJobsUiState
import com.assignment.pgrkam_app.viewmodels.GovtJobsViewModel
import com.assignment.pgrkam_app.viewmodels.RecommendationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MostSuitableJobsFragment : Fragment() {

    private var _binding: FragmentMostSuitableJobsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MostSuitableJobsAdapter
    private lateinit var recommendationAdapter: RecommendationAdapter
    private lateinit var viewModel: GovtJobsViewModel
    private lateinit var recommendationViewModel: RecommendationViewModel
    private lateinit var govList : List<GovtJobs>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMostSuitableJobsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[GovtJobsViewModel::class.java]
        recommendationViewModel = ViewModelProvider(this)[RecommendationViewModel::class.java]
        recommendationAdapter = RecommendationAdapter()
        binding.rvRecommended.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recommendationAdapter
        }
        viewModel.getGovtJobs()
        lifecycleScope.launch  {
                viewModel.govtJobsUiState.collect {
                    when(it) {
                        GovtJobsUiState.Error -> {

                        }
                        is GovtJobsUiState.GovtJobsList -> {
                            govList = it.list
                            binding.progress.visibility = View.GONE
                            binding.main.visibility = View.VISIBLE
                        }
                        GovtJobsUiState.Loading -> {
                            binding.progress.visibility = View.VISIBLE
                            binding.main.visibility = View.GONE
                        }
                    }
                }
            }
        return binding.root
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->
            when(checkedId) {
                R.id.button1 -> {
                    binding.rvGovernment.visibility = View.GONE
                    binding.rvPrivate.visibility = View.GONE
                    binding.rvRecommended.visibility = View.VISIBLE
                    binding.button1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.app_light))
                    binding.button2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
                    binding.button3.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
                }
                R.id.button2 -> {
                    binding.rvGovernment.visibility = View.GONE
                    binding.rvPrivate.visibility = View.VISIBLE
                    binding.rvRecommended.visibility = View.GONE
                    binding.button1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
                    binding.button2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.app_light))
                    binding.button3.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
                    Toast.makeText(requireContext(),"Private",Toast.LENGTH_LONG).show()

                }
                R.id.button3 -> {
                    binding.rvGovernment.visibility = View.VISIBLE
                    binding.rvPrivate.visibility = View.GONE
                    binding.rvRecommended.visibility = View.GONE
                    binding.button1.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
                    binding.button2.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
                    binding.button3.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.app_light))
                    adapter = MostSuitableJobsAdapter(govList)
                    binding.rvGovernment.adapter = adapter
                    binding.rvGovernment.layoutManager =LinearLayoutManager(requireContext())
                }
            }
        }


        recommendationViewModel.getRecommendedJobs()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                recommendationViewModel.recommendationUiState.collect {
                    recommendationAdapter.setRecommendationResponseItemList(it)
                }
            }
        }

    }
}