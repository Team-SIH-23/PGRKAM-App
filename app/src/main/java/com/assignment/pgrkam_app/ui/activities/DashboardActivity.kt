package com.assignment.pgrkam_app.ui.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.ui.AppBarConfiguration
import com.assignment.pgrkam_app.R
import com.assignment.pgrkam_app.databinding.ActivityDashboardBinding
import com.assignment.pgrkam_app.databinding.ViewNavDrawerHeaderBinding
import com.google.android.material.internal.ViewUtils.hideKeyboard
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding : ActivityDashboardBinding
    private lateinit var navHeaderBinding: ViewNavDrawerHeaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)

        setupNavigationBar()

        setSupportActionBar(binding.toolbarDashboard)
        setContentView(binding.root)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.local_services-> {

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

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                if (slideOffset != 0f) super.onDrawerSlide(drawerView, slideOffset)
            }
        }
        binding.drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

    }
}