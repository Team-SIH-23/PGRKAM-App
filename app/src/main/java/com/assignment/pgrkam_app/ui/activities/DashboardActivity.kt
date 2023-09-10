package com.assignment.pgrkam_app.ui.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.assignment.pgrkam_app.R
import com.assignment.pgrkam_app.databinding.ActivityDashboardBinding
import com.assignment.pgrkam_app.databinding.ViewNavDrawerHeaderBinding
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var navHeaderBinding: ViewNavDrawerHeaderBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDashboard)

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

            }
            R.id.search_more_jobs -> {

            }
            R.id.search_counsellor -> {

            }
            R.id.self_employment -> {

            }
            R.id.query -> {

            }
            R.id.foreign_counselling -> {

            }
            R.id.local_services -> {

            }
            R.id.skill_development -> {

            }
            R.id.whats_new -> {

            }
        }
        return false
    }

    private fun setupNavigationBar() {
        navHeaderBinding = ViewNavDrawerHeaderBinding.bind(binding.navigationView.getHeaderView(0))


        binding.navigationView.setNavigationItemSelectedListener(this)
        val actionBarDrawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            binding.drawer, binding.toolbarDashboard, R.string.app_name, R.string.close_drawer
        ) {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                if (slideOffset != 0f) super.onDrawerSlide(drawerView, slideOffset)
            }
        }
        binding.drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

    }
}