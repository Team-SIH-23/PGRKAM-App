package com.assignment.pgrkam_app.models

data class DistrictResponse(
    val state_id: String,
    val state_name: String,
    val dist: List<Districts>
)
