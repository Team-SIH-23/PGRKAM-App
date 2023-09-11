package com.assignment.pgrkam_app.api

import com.assignment.pgrkam_app.models.DistrictResponse
import com.assignment.pgrkam_app.models.GovtJobs
import com.assignment.pgrkam_app.models.LocalServiceResponse
import retrofit2.http.GET

interface RetrofitService {

    @GET("m_api/v1/index.php/govt-job/index")
    suspend fun getGovtJobs(): List<GovtJobs>

    @GET("m_api/v1/index.php/state/index")
    suspend fun getDistrictData(): List<DistrictResponse>

    @GET("m_api/v1/index.php/search-service/index")
    suspend fun getLocalServices(): LocalServiceResponse

}