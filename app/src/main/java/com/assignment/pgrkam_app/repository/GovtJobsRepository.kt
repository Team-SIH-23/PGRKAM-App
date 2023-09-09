package com.assignment.pgrkam_app.repository

import com.assignment.pgrkam_app.api.RetrofitService
import com.assignment.pgrkam_app.models.GovtJobs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GovtJobsRepository @Inject constructor(private val service: RetrofitService) {

    suspend fun getGovtJobs(): Flow<List<GovtJobs>> {
        return flow {
            emit(service.getGovtJobs())
        }
    }

}