package com.assignment.pgrkam_app.utils

import com.assignment.pgrkam_app.models.LocalService

sealed class LocalServiceUiState {
    object Loading : LocalServiceUiState()
    object Error : LocalServiceUiState()
    data class LocalServiceList(val list: List<LocalService>) : LocalServiceUiState()
}
