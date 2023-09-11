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
import com.assignment.pgrkam_app.databinding.FragmentLocalServiceBinding
import com.assignment.pgrkam_app.utils.DistrictUiState
import com.assignment.pgrkam_app.viewmodels.DistrictViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocalServiceFragment : Fragment() {

    private var _binding: FragmentLocalServiceBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DistrictViewModel

    private var listOfDistricts: ArrayList<String> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocalServiceBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[DistrictViewModel::class.java]
        viewModel.getDistrictData()
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

    }

}