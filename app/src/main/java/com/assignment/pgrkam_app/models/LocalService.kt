package com.assignment.pgrkam_app.models

data class LocalService(
    val Address: String,
    val city: String,
    val subdistrict: String,
    val district: String,
    val img: String,
    val profile_image: String?,
    val mobile: String,
    val org_name: String,
    val provider_id: String,
    val service_end_time: String?,
    val service_id: String,
    val service_start_time: String?,
    val services_name: String,
    val rating: Int
)