package com.assignment.pgrkam_app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.pgrkam_app.repository.GovtJobsRepository
import com.assignment.pgrkam_app.utils.GovtJobsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GovtJobsViewModel @Inject constructor(private val govtJobsRepository: GovtJobsRepository) :
    ViewModel() {

    private val _govtJobsUiState = MutableStateFlow<GovtJobsUiState>(GovtJobsUiState.Loading)
    val govtJobsUiState: StateFlow<GovtJobsUiState> = _govtJobsUiState

    fun getGovtJobs() {
        viewModelScope.launch {
            _govtJobsUiState.value = GovtJobsUiState.Loading
            govtJobsRepository.getGovtJobs().catch {
                _govtJobsUiState.value = GovtJobsUiState.Error
            }.collect {
                _govtJobsUiState.value = GovtJobsUiState.GovtJobsList(it)
            }
        }
    }

}