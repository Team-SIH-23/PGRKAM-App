package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.pgrkam_app.databinding.FragmentMostSuitableJobsBinding

class MostSuitableJobsFragment : Fragment() {

    private var _binding: FragmentMostSuitableJobsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMostSuitableJobsBinding.inflate(inflater, container, false)
        return binding.root
    }
}