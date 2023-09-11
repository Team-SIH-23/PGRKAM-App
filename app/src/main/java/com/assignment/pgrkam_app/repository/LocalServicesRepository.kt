package com.assignment.pgrkam_app.repository

import com.assignment.pgrkam_app.api.RetrofitService
import com.assignment.pgrkam_app.models.LocalServiceResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalServicesRepository @Inject constructor(private val retrofitService: RetrofitService) {

    suspend fun getLocalService(): Flow<LocalServiceResponse> {
        return flow {
            emit(retrofitService.getLocalServices())
        }
    }

}