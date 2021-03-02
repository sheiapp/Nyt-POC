package com.example.nytpoc.di

import com.example.nytpoc.network.APIService
import com.example.nytpoc.repository.Repo
import com.example.nytpoc.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepoModule {
    @Provides
    fun homeRepoProvider(
        apiService: APIService
    ) = Repo(apiService) as Repository
}