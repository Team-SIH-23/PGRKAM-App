package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.pgrkam_app.databinding.FragmentJobBinding
import com.assignment.pgrkam_app.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class JobFragment : Fragment() {

    private lateinit var binding: FragmentJobBinding
    var tabTitle = arrayOf("Most Suitable Jobs", "Applied Jobs", "Scheduled Job Interview")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJobBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pager = binding.viewPager
        pager.isSaveEnabled = false
        val tl = binding.tabs
        pager.adapter = ViewPagerAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(tl, pager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}