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
import com.assignment.pgrkam_app.databinding.FragmentLocalServiceBinding
import com.assignment.pgrkam_app.ui.adapter.LocalServiceAdapter
import com.assignment.pgrkam_app.utils.DistrictUiState
import com.assignment.pgrkam_app.utils.LocalServiceUiState
import com.assignment.pgrkam_app.viewmodels.DistrictViewModel
import com.assignment.pgrkam_app.viewmodels.LocalServiceViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LocalServiceFragment : Fragment() {

    private var _binding: FragmentLocalServiceBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DistrictViewModel
    private lateinit var localServiceViewModel: LocalServiceViewModel

    private var listOfDistricts: ArrayList<String> = arrayListOf()

    @Inject
    lateinit var localServiceAdapter: LocalServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocalServiceBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[DistrictViewModel::class.java]
        localServiceViewModel = ViewModelProvider(this)[LocalServiceViewModel::class.java]
        viewModel.getDistrictData()
        localServiceViewModel.getLocalService()
        binding.rvLocalServices.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = localServiceAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.districtUiState.collect { it ->
                    when (it) {
                        is DistrictUiState.DistrictList -> {
                            val punjabDistricts = it.list
                                .filter { it.state_name == "Punjab" }
                                .flatMap { it.dist }
                                .map { it.name }

                            listOfDistricts.addAll(punjabDistricts)
                            binding.etDistrict.setSimpleItems(listOfDistricts.toTypedArray())
                        }
                        DistrictUiState.Error -> {

                        }
                        DistrictUiState.Loading -> {

                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                localServiceViewModel.localServiceUiState.collect {
                    when (it) {
                        LocalServiceUiState.Error -> {

                        }
                        LocalServiceUiState.Loading -> {

                        }
                        is LocalServiceUiState.LocalServiceList -> {
                            localServiceAdapter.setUpPinnedRepoList(it.list)
                        }
                    }
                }
            }
        }


    }

}