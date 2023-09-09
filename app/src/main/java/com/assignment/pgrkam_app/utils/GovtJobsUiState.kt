package com.assignment.pgrkam_app.utils

import com.assignment.pgrkam_app.models.GovtJobs

sealed class GovtJobsUiState {
    object Loading : GovtJobsUiState()
    object Error : GovtJobsUiState()
    data class GovtJobsList(val list: List<GovtJobs>) : GovtJobsUiState()
}
