package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.pgrkam_app.databinding.FragmentSearchCounsellorBinding

class SearchCounsellorFragment : Fragment() {

    private lateinit var binding: FragmentSearchCounsellorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchCounsellorBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            "Architecture and Planning",
            "Pure Science",
            "Medicine and Surgery",
            "Medicine and surgery"
        )
        binding.etAreaOfInterest.setSimpleItems(list.toTypedArray())

        binding.btnSearch.setOnClickListener {

        }
    }
}