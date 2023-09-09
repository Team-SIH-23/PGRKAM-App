package com.assignment.pgrkam_app.api

import com.assignment.pgrkam_app.models.GovtJobs
import retrofit2.http.GET

interface RetrofitService {

    @GET("m_api/v1/index.php/govt-job/index")
    suspend fun getJobPosts(): List<GovtJobs>

}