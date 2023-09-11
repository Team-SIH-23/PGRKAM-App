package com.assignment.pgrkam_app.repository

import com.assignment.pgrkam_app.api.RetrofitService
import com.assignment.pgrkam_app.models.DistrictResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DistrictRepository @Inject constructor(private val service: RetrofitService) {

    suspend fun getDistrictData(): Flow<List<DistrictResponse>> {
        return flow {
            emit(service.getDistrictData())
        }
    }
}