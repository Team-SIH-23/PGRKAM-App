package com.assignment.pgrkam_app.di

import com.assignment.pgrkam_app.api.RetrofitService
import com.assignment.pgrkam_app.repository.DistrictRepository
import com.assignment.pgrkam_app.repository.GovtJobsRepository
import com.assignment.pgrkam_app.repository.LocalServicesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesGovtJobsRepository(retrofitService: RetrofitService): GovtJobsRepository {
        return GovtJobsRepository(retrofitService)
    }

    @Provides
    fun providesDistrictRepository(retrofitService: RetrofitService): DistrictRepository {
        return DistrictRepository(retrofitService)
    }

    @Provides
    fun providesLocalServices(retrofitService: RetrofitService): LocalServicesRepository {
        return LocalServicesRepository(retrofitService)
    }

}