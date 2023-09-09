package com.assignment.pgrkam_app.di

import com.assignment.pgrkam_app.api.RetrofitService
import com.assignment.pgrkam_app.repository.GovtJobsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesGovtJobsRepository(retrofitService: RetrofitService): GovtJobsRepository {
        return GovtJobsRepository(retrofitService)
    }

}