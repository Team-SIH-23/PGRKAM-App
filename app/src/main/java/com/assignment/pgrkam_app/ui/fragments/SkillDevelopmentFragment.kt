package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.pgrkam_app.databinding.FragmentSkillDevelopmentBinding

class SkillDevelopmentFragment : Fragment() {

    private lateinit var binding: FragmentSkillDevelopmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSkillDevelopmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}