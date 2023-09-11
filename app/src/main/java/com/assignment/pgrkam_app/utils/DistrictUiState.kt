package com.assignment.pgrkam_app.utils

import com.assignment.pgrkam_app.models.DistrictResponse

sealed class DistrictUiState {
    object Loading : DistrictUiState()
    object Error : DistrictUiState()
    data class DistrictList(val list: List<DistrictResponse>) : DistrictUiState()
}
