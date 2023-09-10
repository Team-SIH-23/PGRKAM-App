package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.pgrkam_app.databinding.FragmentQueryBinding


class QueryFragment : Fragment() {

    private var _binding: FragmentQueryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQueryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val issues = arrayListOf(
            "Mobile App Related Issues",
            "DBEE Related Query",
            "Website Related Query",
            "Mobile App Related Query",
            "Other"
        )

        binding.etTypeOfIssue.setSimpleItems(issues.toTypedArray())
    }
}