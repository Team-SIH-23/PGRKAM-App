package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.pgrkam_app.databinding.FragmentJobInterestBinding

class JobInterestFragment : Fragment() {

    private var _binding: FragmentJobInterestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobInterestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jobSector = arrayListOf(
            "Agriculture",
            "Apparel",
            "Automotive",
            "BFSI",
            "Beauty & Wellness",
            "Capital Goods & Manufacturing",
            "Construction",
            "Electronics & HW",
            "GEM & Jewellery",
            "HealthCare",
            "IT",
            "Leather",
            "Mining",
            "Organized Retail",
            "Plumbing",
            "Telecom",
            "Tourism & Hospitality",
            "Judiciary",
            "Legal Activities",
            "Optical Products",
            "Power",
            "Printing",
            "Railways",
            "Shipping"
        )

        val jobSectorProfile = arrayListOf(
            "Analyst",
            "Application Maintenance Engineer",
            "Analyst-Research",
            "Associate - CRM",
            "Associate - Customer Care",
            "Associate Analytics",
            "Associate - SCM",
            "Associate-Learning",
            "Associate Network Engineer",
            "Associate Operations Engineer",
            "Associate-Transactional F & A",
            "Associate-Clinical Data Management",
            "Associate-Desktop Publishing",
            "Associate-Editorial","Associate-Medical Transcription",
            "Associate-HRO","Associate-Recruitment","Call Center Executive",
            "Coding Clerk", "Collections Executive","Computer Programmer",
            "Computer Security Specialist","CRM Domestic Voice", "Database Administrator",
            "Junior Data Associate", "IP Executive", "Infrastructure Engineer"
        )

        binding.etJobSector.setSimpleItems(jobSector.toTypedArray())
        binding.etJobSectorProfile.setSimpleItems(jobSectorProfile.toTypedArray())

    }
}