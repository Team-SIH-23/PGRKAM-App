package com.assignment.pgrkam_app.ui.activities

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.assignment.pgrkam_app.R
import com.assignment.pgrkam_app.databinding.ActivityDashboardBinding
import com.assignment.pgrkam_app.databinding.ViewNavDrawerHeaderBinding
import com.google.android.material.navigation.NavigationView
import com.posthog.android.PostHog
import com.posthog.android.Properties
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var navHeaderBinding: ViewNavDrawerHeaderBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.toolbarDashboard)

        setupNavigationBar()

        appBarConfiguration = AppBarConfiguration.Builder()
            .setDrawerLayout(binding.drawer)
            .build()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile_details -> {

            }

            R.id.my_job_intrest -> {
                val eventProperties = Properties()
                    .putValue("Button Clicked", "Job Interest")
                PostHog.with(this).capture("Job Interest", eventProperties)
                findNavController(R.id.nav_host_fragment).navigate(R.id.jobInterestFragment)
            }

            R.id.search_more_jobs -> {

            }

            R.id.search_counsellor -> {
                val eventProperties = Properties()
                    .putValue("Button Clicked", "Search Counsellor")
                PostHog.with(this).capture("Search Counsellor", eventProperties)
                findNavController(R.id.nav_host_fragment).navigate(R.id.searchCounsellorFragment)
            }

            R.id.self_employment -> {

            }

            R.id.query -> {
                val eventProperties = Properties()
                    .putValue("Button Clicked", "Query")
                PostHog.with(this).capture("Query", eventProperties)
                findNavController(R.id.nav_host_fragment).navigate(R.id.queryFragment)
            }

            R.id.foreign_counselling -> {
                val eventProperties = Properties()
                    .putValue("Button Clicked", "Foreign Counselling")
                PostHog.with(this).capture("Foreign Counselling", eventProperties)
                findNavController(R.id.nav_host_fragment).navigate(R.id.counsellingFragment)
            }

            R.id.local_services -> {
                val eventProperties = Properties()
                    .putValue("Button Clicked", "Local Services")
                PostHog.with(this).capture("Local Services", eventProperties)
                findNavController(R.id.nav_host_fragment).navigate(R.id.localServiceFragment)
            }

            R.id.skill_development -> {
                val eventProperties = Properties()
                    .putValue("Button Clicked", "Skill Development")
                PostHog.with(this).capture("Skill Development", eventProperties)
                val uri = Uri.parse("https://www.psdm.gov.in/")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }

            R.id.whats_new -> {
                val eventProperties = Properties()
                    .putValue("Button Clicked", "Whats New")
                PostHog.with(this).capture("Whats New", eventProperties)
                val uri = Uri.parse("https://www.pgrkam.com/")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
        binding.drawer.closeDrawer(GravityCompat.START)
        return false
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupNavigationBar() {
        navHeaderBinding = ViewNavDrawerHeaderBinding.bind(binding.navigationView.getHeaderView(0))
        navHeaderBinding.progressProfile.scaleY = 2f


        binding.navigationView.setNavigationItemSelectedListener(this)
        val actionBarDrawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            binding.drawer, binding.toolbarDashboard, R.string.app_name, R.string.close_drawer
        ) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                navHeaderBinding.progressProfile.setProgress(40, true)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                navHeaderBinding.progressProfile.setProgress(0, true)
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                if (slideOffset != 0f) super.onDrawerSlide(drawerView, slideOffset)
            }
        }
        binding.drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

    }
}