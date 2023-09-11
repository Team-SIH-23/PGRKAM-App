package com.assignment.pgrkam_app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.pgrkam_app.repository.LocalServicesRepository
import com.assignment.pgrkam_app.utils.LocalServiceUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalServiceViewModel @Inject constructor(private val repository: LocalServicesRepository) :
    ViewModel() {

    private val _localServiceUiState =
        MutableStateFlow<LocalServiceUiState>(LocalServiceUiState.Loading)
    val localServiceUiState: StateFlow<LocalServiceUiState> = _localServiceUiState

    fun getLocalService() {
        viewModelScope.launch {
            _localServiceUiState.value = LocalServiceUiState.Loading
            repository.getLocalService().catch {
                _localServiceUiState.value = LocalServiceUiState.Error
            }.collect {
                _localServiceUiState.value = LocalServiceUiState.LocalServiceList(it.data)
            }
        }
    }

}