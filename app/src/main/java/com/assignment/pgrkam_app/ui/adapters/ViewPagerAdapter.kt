package com.assignment.pgrkam_app.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.assignment.pgrkam_app.ui.fragments.AppliedJobsFragment
import com.assignment.pgrkam_app.ui.fragments.MostSuitableJobsFragment
import com.assignment.pgrkam_app.ui.fragments.ScheduledJobInterviewFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MostSuitableJobsFragment()
            1 -> AppliedJobsFragment()
            else -> ScheduledJobInterviewFragment()
        }
    }
}