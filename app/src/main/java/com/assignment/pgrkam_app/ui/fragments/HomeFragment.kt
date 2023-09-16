package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.assignment.pgrkam_app.R
import com.assignment.pgrkam_app.databinding.FragmentHomeBinding
import com.posthog.android.PostHog
import com.posthog.android.Properties

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvHallTicket.setOnClickListener {
            val eventProperties = Properties()
                .putValue("Button Clicked", "Hall Ticket")
            PostHog.with(requireContext()).capture("Hall Ticket", eventProperties)
            findNavController().navigate(R.id.action_homeFragment_to_hallTicketFragment)
        }

        binding.cvJobs.setOnClickListener {
            val eventProperties = Properties()
                .putValue("Button Clicked", "Jobs")
            PostHog.with(requireContext()).capture("Job", eventProperties)
            findNavController().navigate(R.id.action_homeFragment_to_jobFragment)
        }

        binding.cvSkillDevelopment.setOnClickListener {
            val eventProperties = Properties()
                .putValue("Button Clicked", "Skill Development")
            PostHog.with(requireContext()).capture("Skill development", eventProperties)
            findNavController().navigate(R.id.action_homeFragment_to_skillDevelopmentFragment)
        }
    }
}