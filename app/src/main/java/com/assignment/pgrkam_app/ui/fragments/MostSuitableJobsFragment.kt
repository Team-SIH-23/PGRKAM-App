package com.assignment.pgrkam_app.ui.fragments

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
import com.assignment.pgrkam_app.utils.GovtJobsUiState
import com.assignment.pgrkam_app.viewmodels.GovtJobsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MostSuitableJobsFragment : Fragment() {

    private var _binding: FragmentMostSuitableJobsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MostSuitableJobsAdapter
    private lateinit var viewModel: GovtJobsViewModel
    private lateinit var govList : List<GovtJobs>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMostSuitableJobsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[GovtJobsViewModel::class.java]
        viewModel.getGovtJobs()
        lifecycleScope.launch  {
                viewModel.govtJobsUiState.collect {
                    when(it) {
                        GovtJobsUiState.Error -> {

                        }
                        is GovtJobsUiState.GovtJobsList -> {
                            govList = it.list
                        }
                        GovtJobsUiState.Loading -> {

                        }
                    }
                }
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioPrivate -> {
                    Toast.makeText(requireContext(),"Pro",Toast.LENGTH_LONG).show()
                }
                R.id.radioGovt -> {
                    adapter = MostSuitableJobsAdapter(govList)
                    binding.rvMostjob.adapter = adapter
                    binding.rvMostjob.layoutManager =LinearLayoutManager(requireContext())
                }
            }
        }

//        binding.button.setOnClickListener {
//            Toast.makeText(requireContext(),"Pro",Toast.LENGTH_LONG).show()
//        }
//
//        binding.button2.setOnClickListener {
//            adapter = MostSuitableJobsAdapter(govList)
//            binding.rvMostjob.adapter = adapter
//            binding.rvMostjob.layoutManager =LinearLayoutManager(requireContext())
//        }
    }
}