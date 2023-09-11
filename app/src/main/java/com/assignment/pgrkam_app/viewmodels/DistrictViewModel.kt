package com.assignment.pgrkam_app.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.pgrkam_app.repository.DistrictRepository
import com.assignment.pgrkam_app.utils.DistrictUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DistrictViewModel @Inject constructor(private val repository: DistrictRepository) :
    ViewModel() {

    private val _districtUiState = MutableStateFlow<DistrictUiState>(DistrictUiState.Loading)
    val districtUiState: StateFlow<DistrictUiState> = _districtUiState

    fun getDistrictData() {
        viewModelScope.launch {
            _districtUiState.value = DistrictUiState.Loading
            repository.getDistrictData().catch {
                _districtUiState.value = DistrictUiState.Error
            }.collect {
                _districtUiState.value = DistrictUiState.DistrictList(it)
            }
        }
    }

}