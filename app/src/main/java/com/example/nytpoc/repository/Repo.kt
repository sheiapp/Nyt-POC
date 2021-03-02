package com.example.nytpoc.repository

import com.example.nytpoc.model.ApiResponse
import com.example.nytpoc.model.Results
import com.example.nytpoc.network.APIService
import com.example.nytpoc.utils.Resource
import com.example.nytpoc.utils.apiValidator
import javax.inject.Inject

class Repo @Inject constructor(private val apiService: APIService) : Repository {
    override suspend fun getApiResponse(): Resource<ApiResponse<List<Results>>> =
        apiValidator { apiService.getMostPopularApiResponse("all-sections") }
}
