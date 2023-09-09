package com.assignment.pgrkam_app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.assignment.pgrkam_app.R
import com.assignment.pgrkam_app.utils.GovtJobsUiState
import com.assignment.pgrkam_app.viewmodels.GovtJobsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: GovtJobsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[GovtJobsViewModel::class.java]
        viewModel.getGovtJobs()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.govtJobsUiState.collect {
                    when(it) {
                        GovtJobsUiState.Error -> {

                        }
                        is GovtJobsUiState.GovtJobsList -> {
                            Log.d("HERE",it.list.toString())
                        }
                        GovtJobsUiState.Loading -> {

                        }
                    }
                }
            }
        }
    }
}